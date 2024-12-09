package com.moksh.pastebin.service;

import com.moksh.pastebin.entity.Paste;

import java.util.UUID;

public interface PasteBinService {

    Paste getPasteById(UUID pasteId);
    Paste getPasteByUrl(String shortUrl);

}
