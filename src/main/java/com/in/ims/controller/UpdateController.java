//package com.in.ims.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.in.ims.entity.TaskAssign;
//import com.in.ims.service.TaskAssignService;
//
//@RestController
//public class UpdateController {
//
//	@Autowired
//    TaskAssignService taskAssignService;
//
//	@PostMapping("/taskUpdate")
//	public ResponseEntity<String> updateTask(@RequestBody TaskAssign taskAssign) {
//	    if (taskAssign.getTaskId() == null) {
//	        return ResponseEntity.badRequest().body("Task ID is required for update.");
//	    }
//
//	    boolean isUpdated = taskAssignService.updateTaskAssign(taskAssign);
//	    if (isUpdated) {
//	        return ResponseEntity.ok("Task updated successfully with ID: " + taskAssign.getTaskId());
//	    } else {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//	                             .body("Task with ID: " + taskAssign.getTaskId() + " not found.");
//	    }
//	}
//
//}
