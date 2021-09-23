package com.app.demo1.Services;

import com.app.demo1.Services.impl.UploadServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService implements UploadServiceInterface {

    private final String fileUpladPath = "/Users/naveen/Desktop/uploaded_";

    @Override
    public void uploadLocal(MultipartFile file) {

        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(fileUpladPath + file.getOriginalFilename());
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
