package com.example.webappfinaltask.services;


import com.example.webappfinaltask.models.User;
import com.example.webappfinaltask.models.enums.Role;
import com.example.webappfinaltask.repositories.ProductRepository;
import com.example.webappfinaltask.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/** Класс UserService реализующий взаимодействие с пользователем
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see UserRepository
 * @see PasswordEncoder
 * @see Role
 * */

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    /** Внедрение зависимости IO, с помощью инверсии управления спринга добавляем сервис
     * @RequiredArgsConstructor чтобы не добавлять конструктор используем анотацию
     * @see UserRepository и
     * @see PasswordEncoder помечены анотацией @Service то он является компонентом,
     * таким образом контейнер спринга, его контекст будет создавать данный бин
     */
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    /**
     * Метод создания нового пользователя
     * @param user принимает пользователь с формы регестрации
     * @return возврощает true если пользователь успешно добавленн или false если случилась ошибка
     */
    public boolean createUser(User user) {
        String userEmail = user.getEmail();
        if (userRepository.findByEmail(userEmail) != null) {
            return false;
        }
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email: {}", userEmail);
        userRepository.save(user);
        return true;
    }
}
