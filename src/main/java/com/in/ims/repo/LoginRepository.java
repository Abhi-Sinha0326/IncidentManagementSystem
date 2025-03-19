package com.in.ims.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.ims.entity.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByLoginId(String loginId);
}
