package com.example.bookstoreSystem;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bookstoreSystem.controller.ImageUploadController;

@SpringBootApplication
public class BookstoreSystemApplication {

	public static void main(String[] args) {
		//creates "uploads" folder - images are stored here
		new File(ImageUploadController.uploadDirectory).mkdir();
		
		SpringApplication.run(BookstoreSystemApplication.class, args);
	}

}
