package com.codegym.login_application.model.service;

import com.codegym.login_application.model.bean.Login;
import com.codegym.login_application.model.bean.User;

public interface UserService {
    User checkLogin(Login login);
}
