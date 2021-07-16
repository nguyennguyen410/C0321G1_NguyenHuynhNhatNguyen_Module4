package com.codegym.login_application.model.repository;

import com.codegym.login_application.model.bean.Login;
import com.codegym.login_application.model.bean.User;

public interface UserRepository {
    User checkLogin(Login login);
}
