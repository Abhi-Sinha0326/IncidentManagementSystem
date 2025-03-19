package com.in.ims.service;


import com.in.ims.entity.Signup;

import java.util.Optional;

public interface SignupService {

	String saveSignupdetails(Signup signup);

	Signup userDetails(String signupId);

	Optional<Signup> teacherDetails(Integer studyingclass, Integer role);

}

