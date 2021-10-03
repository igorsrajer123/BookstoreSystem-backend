package com.example.bookstoreSystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookstoreSystem.model.Bookstore;
import com.example.bookstoreSystem.model.User;
import com.example.bookstoreSystem.service.BookstoreService;
import com.example.bookstoreSystem.service.UserService;

@RestController
public class ImageUploadController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookstoreService bookstoreService;
	
	@PostMapping("/uploadProfileImage/{email}")
	public ResponseEntity<?> uploadProfileImage(@PathVariable("email") String email, final @RequestParam("file") MultipartFile file) throws IOException {
		try {
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			
			User myUser = userService.findOneByEmail(email);
			myUser.setProfileImageName(fileName);
			userService.save(myUser);
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
		    stream.close();
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/uploadBookstoreImage/{id}")
	public ResponseEntity<?> uploadBookstoreImage(@PathVariable("id") Long id, final @RequestParam("file") MultipartFile file) throws IOException {
		try {
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			
			Bookstore myBookstore = bookstoreService.findOneById(id);
			myBookstore.setPhoto(fileName);
			bookstoreService.save(myBookstore);
			

			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
		    stream.close();
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
