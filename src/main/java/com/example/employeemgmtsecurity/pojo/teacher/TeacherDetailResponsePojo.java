package com.example.employeemgmtsecurity.pojo.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class TeacherDetailResponsePojo {
    private Long teacher_id;
    private String teacher_name;
    private String email;
}
