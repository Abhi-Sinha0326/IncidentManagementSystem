package com.in.ims.dao;

import com.in.ims.entity.Signup;

import java.util.List;
import java.util.Optional;

public interface SignupServiceDao {
    Signup saveSignupdetails(Signup signup);
    Signup findBySignupId(String signupId);
    Optional<Signup> findBySignupIdStartingWith(String prefix);
    Optional<Signup> findByRoleAndStudyingclass(int role, Integer studyingclass);
    Optional<Signup> findByRoleAndStudyingclassAndRollnumber(int role, Integer studyingclass, Integer rollnumber);
    List<Signup> findStudentsByRoleAndStudyingclass(int role, Integer studyingclass);

}
