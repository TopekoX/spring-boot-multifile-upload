package com.timposu.upload;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		//new File(UploadingController.UPLOAD_DIR).mkdirs();
		SpringApplication.run(DemoApplication.class, args);
	}
}
