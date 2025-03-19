package com.in.ims.service.impl;

import com.in.ims.dao.MarksRepository;
import com.in.ims.entity.MarksTable;
import com.in.ims.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarksServiceImpl implements MarksService {

	@Autowired
	private MarksRepository marksRepository;

	@Override
	public Optional<MarksTable> findByRollnumberAndStudyingclass(int rollnumber, int studyingclass) {
		return marksRepository.findByRollnumberAndStudyingclass(rollnumber, studyingclass);
	}

	@Override
	public void saveMarks(MarksTable marks) {
		marksRepository.save(marks);
	}

	@Override
	public List<MarksTable> getMarksByRollnumberAndClass(int rollnumber, int studyingclass) {
		return marksRepository.findListByRollnumberAndStudyingclass(rollnumber, studyingclass);
	}

	@Override
	public List<MarksTable> getMarksByClass(int studyingclass) {
		return marksRepository.findByStudyingclass(studyingclass);
	}

	@Override
	public List<MarksTable> getAllMarks() {
		return marksRepository.findAll();
	}
}
