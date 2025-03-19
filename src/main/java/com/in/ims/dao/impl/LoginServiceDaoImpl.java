package com.in.ims.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in.ims.dao.LoginServiceDao;
import com.in.ims.entity.Login;
import com.in.ims.repo.LoginRepository;


@Repository
public class LoginServiceDaoImpl implements LoginServiceDao {

    @Autowired
    private LoginRepository loginRepo;

    @Override
    public Optional<Login> findByLoginId(String loginId) {
        return loginRepo.findByLoginId(loginId);
    }

    @Override
    public void saveLoginDetails(Login login) {
        loginRepo.save(login);
    }
}

