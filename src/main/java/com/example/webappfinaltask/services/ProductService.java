package com.example.webappfinaltask.services;


import com.example.webappfinaltask.models.Image;
import com.example.webappfinaltask.models.Product;
import com.example.webappfinaltask.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/** Класс ProductService реализующий взаимодействие с продуктом
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see ProductRepository
 * */

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    /** Внедрение зависимости IO, с помощью инверсии управления спринга добавляем сервис
     * @RequiredArgsConstructor чтобы не добавлять конструктор используем анотацию
     * @see ProductRepository помечен анотацией @Service то он является компонентом,
     * таким образом контейнер спринга, его контекст будет создавать данный бин
     */
    private final ProductRepository productRepository;


    /**
     * Метод для получения всего списка товаров
     * @param title заголовок
     * @return возрощается весь список товаров
     */
    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    /**
     * Метод для сохранения товаров
     * @param product товар
     * @param file1 файл
     * @param file2 файл
     * @param file3 файл
     * @throws IOException
     */

    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }


    /**
     * Метод который преобразовывает файл из MultipartFile в фотографиию
     * @param file
     * @return
     * @throws IOException
     */
    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    /**
     * Метод удаление продукта по заданному айди
     * @param id идентификатор
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Метод поиска продукта по заданному айди
     * @param id идентификатор
     * @return возрощает null если товара с таким айдти не найденно
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
