package com.example.demo.domain.file;

import com.cloudinary.Cloudinary;
import com.example.demo.domain.file.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UploadFile {

    @Autowired
    @Qualifier("com.cloudinary.cloud_name")
    String mCloudName;

    @Autowired
    @Qualifier("com.cloudinary.api_key")
    String mApiKey;

    @Autowired
    @Qualifier("com.cloudinary.api_secret")
    String mApiSecret;

    public FileResponse uploadFile(MultipartFile file, Map map) {
        Cloudinary cloudinary = new Cloudinary("cloudinary://" + mApiKey + ":" + mApiSecret + "@" + mCloudName);
        try {
            File fileResult = Files.createTempFile("temp", file.getOriginalFilename()).toFile();
            file.transferTo(fileResult);
            Map response = cloudinary.uploader().upload(fileResult, map);
            JSONObject json = new JSONObject(response);
            return new FileResponse(json.get("url").toString(), file.getOriginalFilename());
        } catch (Exception e) {
            throw new BadRequestException("File is not valid");
        }
    }

    public FileResponse uploadThumbnail(MultipartFile file) {
        Map map = new HashMap();
        return uploadFile(file, map);
    }

    public FileResponse uploadVideo(MultipartFile file) {
        Map map = new HashMap();
        map.put("resource_type", "video");
        map.put("chunk_size", 6000000);
        return uploadFile(file,map);
    }


}
