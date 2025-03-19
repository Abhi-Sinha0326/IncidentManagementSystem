package com.in.ims.service;

import com.in.ims.entity.MarksTable;

import java.util.List;
import java.util.Optional;

public interface MarksService {
	Optional<MarksTable> findByRollnumberAndStudyingclass(int rollnumber, int studyingclass);
	void saveMarks(MarksTable marks);
	List<MarksTable> getMarksByRollnumberAndClass(int rollnumber, int studyingclass);
	List<MarksTable> getMarksByClass(int studyingclass);
	List<MarksTable> getAllMarks();

}
