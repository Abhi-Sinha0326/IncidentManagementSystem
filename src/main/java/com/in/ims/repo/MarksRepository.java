package com.in.ims.dao;

import com.in.ims.entity.MarksTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<MarksTable, Long> {
	Optional<MarksTable> findByRollnumberAndStudyingclass(int rollnumber, int studyingclass);
	List<MarksTable> findListByRollnumberAndStudyingclass(int rollnumber, int studyingclass);
	List<MarksTable> findByStudyingclass(int studyingclass);
	List<MarksTable> findAll();
}
