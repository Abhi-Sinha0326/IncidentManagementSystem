package com.in.ims.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.in.ims.dao.SignupServiceDao;
import com.in.ims.entity.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.ims.dao.LoginServiceDao;
import com.in.ims.entity.Login;
import com.in.ims.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginServiceDao loginServiceDao;

    @Autowired
    SignupServiceDao signupServiceDao;

    @Override
    public boolean authenticate(String loginId, String password) {
        return loginServiceDao.findByLoginId(loginId)
                .filter(login -> login.getPassword().equals(sha256Encrypt(password)))
                .isPresent();
    }

    @Override
    public void saveLoginDetails(Login login) {
        loginServiceDao.saveLoginDetails(login);
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
    public List<Signup> getUsersByRoleAndClass(int role, int studyingclass) {
        return signupServiceDao.findStudentsByRoleAndStudyingclass(role, studyingclass);
    }

}
