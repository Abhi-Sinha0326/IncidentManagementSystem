//package com.in.ims.dao.impl;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Optional;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.in.ims.dao.TaskAssignServiceDao;
//import com.in.ims.entity.TaskAssign;
//import com.in.ims.repo.TaskAssignRepo;
//
//
//@Repository
//public class TaskAssignServiceDaoImpl implements TaskAssignServiceDao{
//
//	@Autowired
//	TaskAssignRepo taskAssignRepo;
//
//
//	@Override
//	public String saveTaskAssign(TaskAssign taskAssign) {
////		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
////	    String generatedTaskId = LocalDateTime.now().format(formatter);
//	    int randomFiveDigit = (int) (Math.random() * 90000) + 10000;
//
//	    String taskType = taskAssign.getTask_type();
//	    String taskNo = taskType + randomFiveDigit;
//	    taskAssign.setTaskId(String.valueOf(taskNo));
//		TaskAssign taskId = taskAssignRepo.save(taskAssign);
//
//		 return taskId.getTaskId();
//	}
//
//	@Override
//	public boolean updateTaskAssign(TaskAssign updatedTask) {
//        Optional<TaskAssign> resp_out = taskAssignRepo.findByTaskId(updatedTask.getTaskId());
//
//        if (resp_out.isPresent()) {
//            TaskAssign existingTask = resp_out.get();
//
////            existingTask.setTaskId(updatedTask.getTaskId());
////            existingTask.setTask(updatedTask.getTask());
//            existingTask.setTask_priority(updatedTask.getTask_priority());
//            existingTask.setStatus(updatedTask.getStatus());
////            existingTask.setTaskOwner(updatedTask.getTaskOwner());
//
//            taskAssignRepo.save(existingTask);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//}
