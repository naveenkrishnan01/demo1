package com.app.demo1.Services.impl;

import org.springframework.web.multipart.MultipartFile;

import java.nio.channels.MulticastChannel;

public interface UploadServiceInterface {

   void uploadLocal(MultipartFile file);
}
