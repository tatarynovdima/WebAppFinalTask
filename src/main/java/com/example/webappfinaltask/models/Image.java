package com.example.webappfinaltask.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/** Класс описывающий сущность Image
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * */


@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    /** Поле индификатора */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    /** Поле имени файла */
    @Column(name = "name")
    private String name;


    /** Поле имени файла */
    @Column(name = "originalFileName")
    private String originalFileName;


    /** Поле размера файла */
    @Column(name = "size")
    private Long size;


    /** Поле расширение файла */
    @Column(name = "contentType")
    private String contentType;


    /** Поле заглавной картинки для продукта */
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;

    /** Поле массива байтов для продукта */
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;
}