package com.in.ims.service;

import com.in.ims.entity.Signup;

import com.in.ims.entity.Login;

import java.util.List;
import java.util.Optional;

public interface LoginService {
    boolean authenticate(String loginId, String password);
    void saveLoginDetails(Login login);
    List<Signup> getUsersByRoleAndClass(int role, int studyingClass);
}

