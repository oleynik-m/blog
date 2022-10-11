package com.sushivesla.blog.service;

import org.springframework.core.io.FileSystemResource;

public interface FileLocationService {
    FileSystemResource find(String imageId);
    String save(byte[] bytes, String imageName) throws Exception;
}
