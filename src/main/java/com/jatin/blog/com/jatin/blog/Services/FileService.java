package com.jatin.blog.com.jatin.blog.Services;

import com.jatin.blog.com.jatin.blog.Config.AppConstants;
import com.jatin.blog.com.jatin.blog.Exceptions.InvalidFileExtensionException;
import com.jatin.blog.com.jatin.blog.ServicesInterfaces.FileServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

@Service
public class FileService implements FileServiceInterface {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String orgFileName = file.getOriginalFilename();
        assert orgFileName != null;
        String fileExtension = orgFileName.substring(orgFileName.lastIndexOf('.'));
        System.out.println(fileExtension);
        if(!Arrays.asList(AppConstants.IMAGE_VALID_EXTENSIONS).contains(fileExtension)){
            throw new InvalidFileExtensionException(orgFileName,fileExtension,"This filetype is not allowed");
        }
        String fileName = UUID.randomUUID().toString().concat(fileExtension);
        String filePath = path + File.separator + fileName;

        File newFile = new File(path);
        if(!newFile.exists()) newFile.mkdir();
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws IOException {
        String fullPath = path + File.separator + fileName;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream;
    }
}
