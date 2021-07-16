package com.codegym.email_settings.model.service;

import com.codegym.email_settings.model.bean.Email;
import com.codegym.email_settings.model.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    EmailRepository emailRepository;

    @Override
    public Email editSettings(Email email) {
        return emailRepository.editSettings(email);
    }

    @Override
    public Email setEmailDefault(){
        return emailRepository.setEmailDefault();
    }
}
