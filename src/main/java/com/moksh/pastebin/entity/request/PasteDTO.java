package com.moksh.pastebin.entity.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.UUID;

import static com.moksh.pastebin.utils.Constants.DEFAULT_TTL;

@Data
public class PasteDTO {

    @NotNull(message = "Id cannot be empty")
    private UUID id;

    @NotNull(message = "FileName cannot be empty")
    private String fileName;

    private Long ttl = DEFAULT_TTL;
}
