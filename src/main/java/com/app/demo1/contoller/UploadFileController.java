package com.app.demo1.contoller;

import com.app.demo1.Services.UploadService;
import com.app.demo1.Services.impl.UploadServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class UploadFileController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
     public void uploadLocal(@RequestParam("file") MultipartFile multipartFile) {
        uploadService.uploadLocal(multipartFile);

     }
}
