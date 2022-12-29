package com.example.webappfinaltask.models;


import com.example.webappfinaltask.models.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/** Класс описывающий сущность User
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see Role
 * */


@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {

    /** Поле индификатора */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** Поле email и так же является именем пользователя */
    @Column(name = "email", unique = true)
    private String email;

    /** Номер телефона */
    @Column(name = "numberPhone", unique = true)
    private String numberPhone;

    /** Поле имени пользователя */
    @Column(name = "name")
    private String name;

    /** Признак активности */
    @Column(name = "active")
    private boolean active;

    /** Поле аватарки */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image avatar;

    /** Поле пароль */
    @Column(name = "password", length = 1000)
    private String password;

    /** поле set ролей */
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    /** Поле поле создания аккаунта */
    private LocalDateTime dateOfCreated;

    /** Метод инициализации времени создании товара*/
    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
