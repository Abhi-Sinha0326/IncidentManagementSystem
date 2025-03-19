package com.in.ims.controller;

import com.in.ims.entity.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.in.ims.service.LoginService;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin("*")
    @PostMapping("/userLogin")
    public ResponseEntity<String> login(@RequestParam String loginId, @RequestParam String password) {
        boolean isAuthenticated = loginService.authenticate(loginId, password);
        System.out.println("checking is authenticated or not"+ isAuthenticated);
        if (isAuthenticated) {
            return ResponseEntity.ok("++++++++++++++Login successful++++++=======");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }

    @GetMapping("/getStudentList")
    public ResponseEntity<List<Signup>> getUsers(@RequestParam int role, @RequestParam int studyingclass) {
        List<Signup> users = loginService.getUsersByRoleAndClass(role, studyingclass);
        return ResponseEntity.ok(users);
    }

}

