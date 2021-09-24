package com.example.bookstoreSystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@PostMapping("/uploadProfileImage")
	public ResponseEntity<?> uploadProfileImage(final @RequestParam("file") MultipartFile file) throws IOException {
		
		try {
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			System.out.println(filePath);
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
		    stream.close();
		 
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getProfilePhoto")
	public ResponseEntity<byte[]> loadProfileImage() throws IOException {
		try {
			 ClassPathResource resource = new ClassPathResource("C:\\Users\\Super User\\Desktop\\Fax\\Diplomski\\Bookstore-backend\\bookstoreSystem\\uploads\\bbbbbbbb.png");
			 byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
			 return new ResponseEntity<byte[]>(bytes, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
