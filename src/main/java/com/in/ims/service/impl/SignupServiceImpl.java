package com.in.ims.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.ims.dao.LoginServiceDao;
import com.in.ims.dao.SignupServiceDao;
import com.in.ims.entity.Login;
import com.in.ims.entity.Signup;
import com.in.ims.service.SignupService;


@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    SignupServiceDao signupServiceDao;

    @Autowired
    LoginServiceDao loginServiceDao;

    @Override
    public String saveSignupdetails(Signup signup) {
        System.out.println("checking role"+signupServiceDao.findBySignupIdStartingWith("Principal_"));
        String generatedSignupId = null;
        if(signup.getRole() == 1){
            generatedSignupId = "Principal" + "_" + signup.getLastName();
            if(signupServiceDao.findBySignupIdStartingWith("Principal_") != null
                    && !signupServiceDao.findBySignupIdStartingWith("Principal_").isEmpty()) {
                throw new IllegalStateException("A Principal role already exists.");
            }
        }
        if (signup.getRole() == 2) {
            generatedSignupId = "Teacher" + "_" + signup.getStudyingclass() + "_" + signup.getLastName();
            if (signupServiceDao.findByRoleAndStudyingclass(2, signup.getStudyingclass()).isPresent()) {
                throw new IllegalStateException("A Teacher for this class is already registered.");
            }
        }
        if (signup.getRole() == 3) {
            generatedSignupId = "Student" + "_" + signup.getStudyingclass() + "_" + signup.getRollnumber() + "_" + signup.getLastName();
            if (signupServiceDao.findByRoleAndStudyingclassAndRollnumber(3,  signup.getStudyingclass(),  signup.getRollnumber()).isPresent()) {
                throw new IllegalStateException("This roll number already exists in the class.");
            }
        }
        System.out.println("checking generatedSignupId"+generatedSignupId);
        signup.setSignupId(generatedSignupId);
        signup.setIsActive(true);
        signup.setCreatedAt(LocalDateTime.now());


        Signup savedSignup = signupServiceDao.saveSignupdetails(signup);


        Login login = new Login();
        login.setSignup(savedSignup);
        login.setRole(savedSignup.getRole());
        login.setStudyingclass(savedSignup.getStudyingclass());
        login.setRollnumber(savedSignup.getRollnumber());
        login.setLoginId(generatedSignupId);
        login.setPassword(sha256Encrypt(signup.getPassword()));
        login.setDisplay(true);
        login.setCreatedAt(LocalDateTime.now());

        loginServiceDao.saveLoginDetails(login);

        return generatedSignupId;
    }

    private String sha256Encrypt(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }

    @Override
    public Signup userDetails(String SignupId){
        return signupServiceDao.findBySignupId(SignupId);
    }

    @Override
    public Optional<Signup> teacherDetails(Integer studyingclass, Integer role){
        return signupServiceDao.findByRoleAndStudyingclass(role, studyingclass);
    }
}
