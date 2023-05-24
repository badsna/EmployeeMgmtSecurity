package com.example.employeemgmtsecurity.service.teacherservice;

import com.example.employeemgmtsecurity.model.Teacher;
import com.example.employeemgmtsecurity.pojo.teacher.TeacherDetailRequestPojo;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> getTeachers();

    public Optional<Teacher> getTeacherById(Long teacher_id);

    public void saveTeacherDetails(TeacherDetailRequestPojo teacherDetailRequestPojo);
}
