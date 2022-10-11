package com.sushivesla.blog.controller;

import com.sushivesla.blog.service.FileLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file-system")
public class FileSystemImageController {
    @Autowired
    FileLocationService fileLocationService;

    @PostMapping("/image")
    String uploadImage(@RequestParam MultipartFile image) throws Exception {
        return fileLocationService.save(image.getBytes(), image.getOriginalFilename());
    }

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    FileSystemResource downloadImage(@PathVariable String imageId) throws Exception {
        return fileLocationService.find(imageId);
    }
}
