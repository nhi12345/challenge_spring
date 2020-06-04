package com.example.demo.rest.upload;

import com.example.demo.domain.file.FileResponse;
import com.example.demo.domain.file.UploadFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UploadResource {

    @Autowired
    private UploadFile service;

    @PostMapping(value="/thumbnail")
    public FileResponse uploadThumbnail(@RequestParam(value="file", required=true) MultipartFile file){
        return service.uploadThumbnail(file);
    }

    @PostMapping(value = "video")
    public FileResponse uploadVideo(@RequestParam(value="file", required=true) MultipartFile file){
        return service.uploadVideo(file);
    }
}
