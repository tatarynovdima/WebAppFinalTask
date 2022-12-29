package com.example.webappfinaltask.controllers;


import com.example.webappfinaltask.models.User;
import com.example.webappfinaltask.services.ProductService;
import com.example.webappfinaltask.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/** Класс описывающий контроллер класса User
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see UserService
 * */


@Controller
@RequiredArgsConstructor
public class UserController {

    /** Внедрение зависимости IO, с помощью инверсии управления спринга добавляем сервис
     * @RequiredArgsConstructor чтобы не добавлять конструктор используем анотацию
     * @see UserService помечен анотацией @Service то он является компонентом,
     * таким образом контейнер спринга, его контекст будет создавать данный бин
     */
    private final UserService userService;


    /**
     * Метод авторизации
     * @return login
     */

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     *  Метод регестрации
     * @return registration
     */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /**
     *  Метод регестрации
     * @return
     */
    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)){
            model.addAttribute("errorMessage","this email is already taken: " + user.getEmail());
            return "registration";
        }
        return "redirect:/login";
    }
}
