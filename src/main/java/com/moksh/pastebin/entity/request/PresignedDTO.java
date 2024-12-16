package com.moksh.pastebin.entity.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class PresignedDTO {
    private String filename;

    public PresignedDTO(String filename) {
        this.filename = filename;
    }

}