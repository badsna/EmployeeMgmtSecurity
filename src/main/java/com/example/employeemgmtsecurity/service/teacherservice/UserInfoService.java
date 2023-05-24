package com.example.employeemgmtsecurity.service.teacherservice;

import com.example.employeemgmtsecurity.config.UserInfoUserDetails;
import com.example.employeemgmtsecurity.model.UserInfo;
import com.example.employeemgmtsecurity.repo.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByName(username);
        UserInfoUserDetails userInfoUserDetails = new UserInfoUserDetails();
        userInfoUserDetails.setUserInfo(userInfo);

        return userInfoUserDetails;
        //I want to return UserDetails but i have UserInfo so create UserInfoUserDetails in config
    }

}
