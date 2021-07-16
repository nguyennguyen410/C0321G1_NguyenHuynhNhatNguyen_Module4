package com.codegym.login_application.model.service;

import com.codegym.login_application.model.bean.Login;
import com.codegym.login_application.model.bean.User;
import com.codegym.login_application.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
