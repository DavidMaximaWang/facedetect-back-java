package com.facedetect.tomcluise.dto;

public class FileUploadResponse {
    private String filename;
    private String contentType;
    private String url;

    public FileUploadResponse(String fileName, String contentType, String url) {
        this.filename = fileName;
        this.contentType = contentType;
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
