package com.timposu.upload;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		File file = new File(UploadingController.UPLOAD_DIR);
		if (!file.exists()) {
			file.mkdirs();
		}
		SpringApplication.run(DemoApplication.class, args);
	}
}
