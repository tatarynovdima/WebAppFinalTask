package com.example.webappfinaltask.controllers;


import com.example.webappfinaltask.models.Image;
import com.example.webappfinaltask.repositories.ImageRepository;
import com.example.webappfinaltask.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

/** Класс описывающий контроллер класса Image
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see ImageRepository
 * */
@RestController
@RequiredArgsConstructor
public class ImageController {

    /** Внедрение зависимости IO, с помощью инверсии управления спринга добавляем сервис
     * @RequiredArgsConstructor чтобы не добавлять конструктор используем анотацию
     * @see ImageRepository помечен анотацией @Service то он является компонентом,
     * таким образом контейнер спринга, его контекст будет создавать данный бин
     */
    private final ImageRepository imageRepository;


    /**
     * Метод получения картинки по заданому айди
     * @param id индификатора
     * @return вернет фотографию если не найденно то null
     */
    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
