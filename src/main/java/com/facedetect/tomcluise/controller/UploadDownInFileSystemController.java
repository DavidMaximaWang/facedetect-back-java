package com.facedetect.tomcluise.controller;

import com.facedetect.tomcluise.dto.FileUploadResponse;
import com.facedetect.tomcluise.result.Result;
import com.facedetect.tomcluise.service.FileStorageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UploadDownInFileSystemController {
    private FileStorageService fileStorageService;

    public UploadDownInFileSystemController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/files")
    @CrossOrigin
    @ResponseBody
    public Result<List<FileUploadResponse>> singleFileUpload(@RequestParam("image0") MultipartFile file){
        String fileName = fileStorageService.storeFile(file);
        //http://localhost:5000/download/abc.jpg
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileName)
                .toUriString();
        String contentType =file.getContentType();
        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url);
        List<FileUploadResponse> f = new ArrayList<>();
        f.add(response);
        return Result.success(f);
    }

    @GetMapping("/download/{fileName}")
    @CrossOrigin
    ResponseEntity<Resource> downloadSingleFile(@PathVariable String fileName, HttpServletRequest request){
        Resource resource = fileStorageService.downloadFile(fileName);
        String mimeType;

        try {
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        mimeType = mimeType == null ? MediaType.APPLICATION_OCTET_STREAM_VALUE : mimeType;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(mimeType));
        ResponseEntity<Resource> responseEntity = new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
        return responseEntity;
    }
}
