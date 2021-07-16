package com.codegym.email_settings.model.service;

import com.codegym.email_settings.model.bean.Email;

public interface EmailService {
    Email editSettings(Email email);
    Email setEmailDefault();
}
