package com.in.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.in.ims.entity.Signup;
import com.in.ims.service.SignupService;

import java.util.Optional;

@RestController
public class SignupController {
    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Signup signup) {
        String signupId = signupService.saveSignupdetails(signup);
        return ResponseEntity.ok(signupId);
    }

    @GetMapping("/userDetails")
    public ResponseEntity<Signup> userDetails(@RequestParam  String signupId) {
        Signup userDetails = signupService.userDetails(signupId);
        return ResponseEntity.ok(userDetails);
    }

    @GetMapping("/teacherDetails")
    public ResponseEntity<Optional<Signup>> teacherDetails(@RequestParam  Integer studyingclass, @RequestParam Integer role) {
        Optional<Signup> teacherDetails = signupService.teacherDetails(studyingclass, role);
        return ResponseEntity.ok(teacherDetails);
    }

}

