package com.project.boardback.service.implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.boardback.service.FileService;

@Service
public class FileServiceImplement implements FileService{

    @Value("${file.path}")
    private String filePath;
    @Value("${file.url}")
    private String fileUrl;

    @Override
    public String upload(MultipartFile file) {
        
        if (file.isEmpty()) return null;

        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String saveFilename = uuid + extension;
        String savePath = filePath + saveFilename;

        try {
            file.transferTo(new File(savePath));
        }catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        String url = fileUrl + saveFilename;
        return url;

    }

    @Override
    public Resource getImage(String fileName) {
        
        Resource resource = null;

        try {
           resource = new UrlResource("file:" + filePath + fileName);
        }catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return resource;
    }
    
}
