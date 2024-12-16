package com.moksh.pastebin.entity.request;

public class PresignedDTO {
    private String filename;

    public PresignedDTO(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}