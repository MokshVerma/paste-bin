package com.moksh.pastebin.service;

import com.moksh.pastebin.entity.Paste;
import com.moksh.pastebin.entity.request.PasteDTO;

import java.util.UUID;

public interface PasteBinService {

    Paste getPasteByUrl(String shortUrl);

    String getPresignedURL(String filename, UUID uuid);

    Paste createPaste(PasteDTO pasteDTO);

}
