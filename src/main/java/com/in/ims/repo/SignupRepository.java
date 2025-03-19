package com.in.ims.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.in.ims.entity.Signup;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Long> {
    Signup findBySignupId(String signupId);
    Optional<Signup> findBySignupIdStartingWith(String prefix);
    Optional<Signup> findByRoleAndStudyingclass(int role, Integer studyingclass);
    Optional<Signup> findByRoleAndStudyingclassAndRollnumber(int role, Integer studyingclass, Integer rollnumber);
    List<Signup> findStudentsByRoleAndStudyingclass(int role, Integer studyingclass);

}
