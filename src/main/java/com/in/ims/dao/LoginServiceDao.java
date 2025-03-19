package com.in.ims.dao;


import java.util.Optional;

import com.in.ims.entity.*;

public interface LoginServiceDao {
    Optional<Login> findByLoginId(String loginId);
    void saveLoginDetails(Login login);
}


