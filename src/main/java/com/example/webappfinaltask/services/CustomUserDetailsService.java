package com.example.webappfinaltask.services;



import com.example.webappfinaltask.repositories.ProductRepository;
import com.example.webappfinaltask.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** Класс CustomUserDetailsService реализующий взаимодействие с авторизацией,
 *  Нужен для того чтобы Spring Security правильно подгружал пользователей
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see UserDetailsService
 * @see UserRepository
 * */

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    /** Внедрение зависимости IO, с помощью инверсии управления спринга добавляем сервис
     * @RequiredArgsConstructor чтобы не добавлять конструктор используем анотацию
     * @see UserRepository помечен анотацией @Service то он является компонентом,
     * таким образом контейнер спринга, его контекст будет создавать данный бин
     */
    private final UserRepository userRepository;


    /**
     * Переопределенный метод для правилной загрузки пользователей
     * @param email
     * @return возращет найденного пользователя по введенному email
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
}
