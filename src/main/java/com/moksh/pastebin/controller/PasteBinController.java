package com.moksh.pastebin.controller;

import com.moksh.pastebin.entity.Paste;
import com.moksh.pastebin.entity.request.PasteDTO;
import com.moksh.pastebin.service.PasteBinService;
import com.moksh.pastebin.service.implementation.PasteBinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PasteBinController {

    private PasteBinServiceImpl pasteBinService;

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public ResponseEntity<Paste> createPaste(@RequestBody PasteDTO pasteDTO){

        Paste paste = new Paste();
        paste.setTtl(pasteDTO.getTtl());
        paste.setShortLinkSuffix(pasteDTO.getShort_link_suffix());
        paste.setContentUrl(pasteDTO.getContent_url());

        return ResponseEntity
                .status(CREATED)
                .header("Location", "/api/items/" + paste.getId())
                .body(paste);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paste> getPaste(@PathVariable("id") UUID id){
        Paste paste = pasteBinService.getPasteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paste);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Paste> getPasteByUrl(@PathVariable("shortUrl") String shortUrl){
        Paste paste = pasteBinService.getPasteByUrl(shortUrl);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paste);
    }



}
