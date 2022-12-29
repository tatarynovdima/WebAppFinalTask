package com.example.webappfinaltask.models.enums;

import org.springframework.security.core.GrantedAuthority;



/** Енам с типом роли которые могут быть у пользователя
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * */
public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    /** Метод получение роли в строковом виде */
    @Override
    public String getAuthority() {
        return name();
    }
}
