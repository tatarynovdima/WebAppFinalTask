package com.example.webappfinaltask.controllers;

import com.example.webappfinaltask.models.Product;
import com.example.webappfinaltask.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/** Класс описывающий контроллер класса Product
 * @author Dmytro Tatarynov <dmytro.course@gmail.com>
 * @version 1.0
 * @see ProductService
 * */

@Controller
@RequiredArgsConstructor
public class ProductController {

    /** Внедрение зависимости IO, с помощью инверсии управления спринга добавляем сервис
     * @RequiredArgsConstructor чтобы не добавлять конструктор используем анотацию
     * @see ProductService помечен анотацией @Service то он является компонентом,
     * таким образом контейнер спринга, его контекст будет создавать данный бин
     */
    private final ProductService productService;


    /**
     * Метод гет запроса, при переходе на корень сайта будет вывзан данный метод
     * @param title заголовок
     * @param model модель, для передачи параметров в шаблонизатор freemarker
     * @return вовращает список всех товаров
     */
    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    /**
     * Метод передает текущие данные о товаре
     * @param id индификатор
     * @param model модель, для передачи параметров в шаблонизатор freemarker
     * @return
     */
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }

    /**
     * Метод создание нового товара
     * @param file1
     * @param file2
     * @param file3
     * @param product товар
     * @return сохранит новый товар и обновит странницу
     * @throws IOException
     */
    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Product product) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    /**
     * Метод удаление товара
     * @param id индификатор
     * @return удалит товар и обновит странницу
     */
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

}
