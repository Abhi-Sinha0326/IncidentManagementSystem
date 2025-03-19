package com.in.ims.controller;

import com.in.ims.entity.MarksTable;
import com.in.ims.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping("/add")
    public ResponseEntity<String> addMarks(@RequestBody MarksTable marks) {
        Optional<MarksTable> existingMarks = marksService.findByRollnumberAndStudyingclass(marks.getRollnumber(), marks.getStudyingclass());

        if (existingMarks.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Marks already exist for Roll Number: " + marks.getRollnumber() + " and Class: " + marks.getStudyingclass());
        }

        marksService.saveMarks(marks);
        return ResponseEntity.status(HttpStatus.CREATED).body("Marks added successfully!");
    }

    @GetMapping("/getMarks")
    public ResponseEntity<List<MarksTable>> getMarks(
            @RequestParam(required = false) Integer rollnumber,
            @RequestParam Integer studyingclass) {

        List<MarksTable> marks;

        if (rollnumber != null) {
            marks = marksService.getMarksByRollnumberAndClass(rollnumber, studyingclass);
        } else {
            marks = marksService.getMarksByClass(studyingclass);
        }

        if (marks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(marks);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MarksTable>> getAllMarks() {
        List<MarksTable> marks = marksService.getAllMarks();
        return ResponseEntity.ok(marks);
    }

}
