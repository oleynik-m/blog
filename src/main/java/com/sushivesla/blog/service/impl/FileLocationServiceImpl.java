package com.sushivesla.blog.service.impl;

import com.sushivesla.blog.model.Image;
import com.sushivesla.blog.repository.FileSystemRepository;
import com.sushivesla.blog.repository.ImageRepository;
import com.sushivesla.blog.service.FileLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FileLocationServiceImpl implements FileLocationService {
    @Autowired
    FileSystemRepository fileSystemRepository;
    @Autowired
    ImageRepository imageRepository;

    @Override
    public FileSystemResource find(String imageId) {
        Image image = imageRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return fileSystemRepository.findInFileSystem(image.getLocation());
    }

    @Override
    public String save(byte[] bytes, String imageName) throws Exception {
        String location = fileSystemRepository.save(bytes, imageName);
        return imageRepository.save(new Image(imageName, location))
                .getId();
    }
}
