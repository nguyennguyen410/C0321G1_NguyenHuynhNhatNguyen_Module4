package com.codegym.email_settings.model.repository;

import com.codegym.email_settings.model.bean.Email;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryImpl implements EmailRepository{
    @Override
    public Email setEmailDefault(){
        Email emailDefault = new Email();
        emailDefault.setLanguages("English");
        emailDefault.setPageSize(25);
        emailDefault.setSpamsFilter("Disable");
        emailDefault.setSignature("No Signature");
        return emailDefault;
    }

    @Override
    public Email editSettings(Email email) {
        Email emailEdited = new Email();
        emailEdited.setLanguages(email.getLanguages());
        emailEdited.setPageSize(email.getPageSize());
        if(email.getSpamsFilter()==null){
            emailEdited.setSpamsFilter("Disable");
        } else {
            emailEdited.setSpamsFilter(email.getSpamsFilter());
        }
        emailEdited.setSignature(email.getSignature());
        return emailEdited;
    }
}
