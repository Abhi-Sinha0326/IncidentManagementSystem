package com.in.ims.dao.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.in.ims.dao.SignupServiceDao;
import com.in.ims.entity.Signup;
import com.in.ims.repo.SignupRepository;

@Repository
public class SignupServiceDaoImpl implements SignupServiceDao {

    @Autowired
    private SignupRepository signupRepo;

    @Override
    public Signup saveSignupdetails(Signup signup) {
        return signupRepo.save(signup);
    }

    @Override
    public Signup findBySignupId(String signupId) {
        return signupRepo.findBySignupId(signupId);
    }

    @Override
    public Optional<Signup> findBySignupIdStartingWith(String prefix) {
        return signupRepo.findBySignupIdStartingWith(prefix);
    }

    @Override
    public Optional<Signup> findByRoleAndStudyingclass(int role, Integer studyingclass) {
        return signupRepo.findByRoleAndStudyingclass(role, studyingclass);
    }

    @Override
    public Optional<Signup> findByRoleAndStudyingclassAndRollnumber(int role, Integer studyingclass, Integer rollnumber) {
        return signupRepo.findByRoleAndStudyingclassAndRollnumber(role, studyingclass, rollnumber);
    }

    @Override
    public List<Signup> findStudentsByRoleAndStudyingclass(int role, Integer studyingclass) {
        return signupRepo.findStudentsByRoleAndStudyingclass(role, studyingclass);
    }


}
