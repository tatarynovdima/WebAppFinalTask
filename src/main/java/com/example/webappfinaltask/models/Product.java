package com.example.webappfinaltask.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/** Класс описывающий сущность Product
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * */


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /** Поле индификатора */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /** Поле заголовка товара */
    @Column(name = "title")
    private String title;

    /** Поле описания товара */
    @Column(name = "description", columnDefinition = "text")

    /** Поле цені товара */
    private String description;
    @Column(name = "price")
    private int price;

    /** Поле города из которого продается товар */
    @Column(name = "city")
    private String city;

    /** Поле автора кто добавил товар на сайт */
    @Column(name = "author")
    private String author;

    /** Поле лист картинок */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "product")
    private List<Image> images = new ArrayList<>();

    /** Поле заглавной картинки для продукта */
    private Long previewImageId;

    /** Поле даты создания товара */
    private LocalDateTime dateOfCreated;


    /** метод инициализации времени создании товара*/
    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    /**
     * Метод назначения фотографии товару, устанавливаем текущию картинку
     * и добавляем в колекцию с изображениями
     * @param image картинку
     */
    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }
}