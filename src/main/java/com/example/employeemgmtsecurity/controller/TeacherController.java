package com.example.employeemgmtsecurity.controller;


import com.example.employeemgmtsecurity.model.Teacher;
import com.example.employeemgmtsecurity.pojo.teacher.TeacherDetailRequestPojo;
import com.example.employeemgmtsecurity.service.teacherservice.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/teacher")
@Validated
public class TeacherController {
    private final TeacherServiceImpl teacherServiceImpl;

    @Autowired
    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<Teacher> getTeacher() {
        return teacherServiceImpl.getTeachers();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{teacher_id}")
    public Optional<Teacher> getTeacherById(@PathVariable("teacher_id") Long teacher_id) {
        return teacherServiceImpl.getTeacherById(teacher_id);
    }

    @PreAuthorize("hasRole('ADMIN')")       //Now only admin can access this method
    @PostMapping("/addNewTeacher")
    public String saveTeacherDetails(@RequestBody TeacherDetailRequestPojo teacherDetailRequestPojo) {
        teacherServiceImpl.saveTeacherDetails(teacherDetailRequestPojo);
        return "Added Successfully";
    }
}
