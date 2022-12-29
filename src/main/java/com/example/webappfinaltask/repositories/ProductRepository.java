package com.example.webappfinaltask.repositories;

import com.example.webappfinaltask.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/** Мы наследуемся от интерфейса JpaRepository, чтобы получить доступ к реализованным
 *  дао классам и реализацию взаимодействия с базой данных, получаем доступ к методом
 *  получить все товары из базы данных, сохранить товар в базу данных, удать товар
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Метод поиска по индификатору
     * @param title заголовок
     * @return возврощает список всех товаров с таким же заголовком
     */
    List<Product> findByTitle(String title);
}
