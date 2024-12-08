package com.moksh.pastebin.entity.request;

import lombok.Data;

@Data
public class PasteDTO {

    private String short_link_suffix;
    private Long ttl;
    private String content_url;

}
