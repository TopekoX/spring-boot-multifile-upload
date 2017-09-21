package com.timposu.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadingController {
	
	public static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/img";
	
	@GetMapping("/")
	public String uploading(Model model) {
		File file = new File(UPLOAD_DIR);
		String[] fileName = new String[file.listFiles().length];
		int index = 0;
		
		for (File f : file.listFiles()) {
			fileName[index] = f.getName();
			index++;
		}
		model.addAttribute("files", fileName);
		return "uploading";
	}

	@PostMapping("/")
	public String uploadedFile(@RequestParam("uploadingfiles") MultipartFile[] files) 
			throws IOException {
		
		for (MultipartFile uploadfile : files) {
			File file = new File(UPLOAD_DIR + "/" + uploadfile.getOriginalFilename());
			uploadfile.transferTo(file);
		}
		return "redirect:/";
	}
}
