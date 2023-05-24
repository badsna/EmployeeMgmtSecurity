package com.example.employeemgmtsecurity.repo;

import com.example.employeemgmtsecurity.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

//save,delete method call garna milxa
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findByName(String username);
}
