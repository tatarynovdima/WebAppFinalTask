package com.example.webappfinaltask.repositories;

import com.example.webappfinaltask.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository  extends JpaRepository<Image, Long> {
}
