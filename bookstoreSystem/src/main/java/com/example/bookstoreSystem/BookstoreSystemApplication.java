package com.example.bookstoreSystem;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.bookstoreSystem.controller.ImageUploadController;

@SpringBootApplication
@EnableScheduling
public class BookstoreSystemApplication {

	public static void main(String[] args) {
		
		new File(ImageUploadController.uploadDirectory).mkdir();
		
		SpringApplication.run(BookstoreSystemApplication.class, args);
	}

}
