package com.example.employeemgmtsecurity.pojo.teacher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TeacherDetailRequestPojo {

    @NotNull
    private String teacher_name;

    private String email;

}
