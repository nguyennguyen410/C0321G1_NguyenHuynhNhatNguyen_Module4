package com.codegym.email_settings.model.repository;

import com.codegym.email_settings.model.bean.Email;

public interface EmailRepository {
    Email editSettings(Email email);
    Email setEmailDefault();
}
