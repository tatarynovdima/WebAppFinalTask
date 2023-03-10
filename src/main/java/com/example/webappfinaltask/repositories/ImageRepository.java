package com.example.webappfinaltask.repositories;

import com.example.webappfinaltask.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/** Интерфейс для изображения
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 * */

/** Мы наследуемся от интерфейса JpaRepository, чтобы получить доступ к реализованным
 *  дао классам и реализацию взаимодействия с базой данных, получаем доступ к методом
 *  получить все товары из базы данных, сохранить товар в базу данных, удать товар
 */
public interface ImageRepository  extends JpaRepository<Image, Long> {
}
