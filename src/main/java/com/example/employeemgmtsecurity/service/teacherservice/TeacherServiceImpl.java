package com.example.employeemgmtsecurity.service.teacherservice;

import com.example.employeemgmtsecurity.model.Teacher;
import com.example.employeemgmtsecurity.pojo.teacher.TeacherDetailRequestPojo;
import com.example.employeemgmtsecurity.repo.TeacherRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    public final TeacherRepo teacherRepo;
    public final TeacherDetailRequestPojo teacherDetailRequestPojo;
    public final ObjectMapper objectMapper;

    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    public Optional<Teacher> getTeacherById(Long teacher_id) {
        boolean exists = teacherRepo.existsById(teacher_id);
        if (!exists) {
            throw new IllegalStateException(
                    "teacher with id " + teacher_id + "doesn't exists"
            );
        }
        return teacherRepo.findById(teacher_id);

    }

    public void saveTeacherDetails(TeacherDetailRequestPojo teacherDetailRequestPojo) {
        Teacher teacher;

        teacher = objectMapper.convertValue(teacherDetailRequestPojo, Teacher.class);
        teacherRepo.save(teacher);
    }
}
