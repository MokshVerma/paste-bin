package com.moksh.pastebin.controller;

import com.moksh.pastebin.entity.Paste;
import com.moksh.pastebin.entity.request.PasteDTO;
import com.moksh.pastebin.entity.request.PresignedDTO;
import com.moksh.pastebin.service.PasteBinService;
import com.moksh.pastebin.service.implementation.PasteBinServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController("pastebin/api/v1/pasta")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PasteBinController {

    private PasteBinServiceImpl pasteBinService;

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public ResponseEntity<Paste> createPaste(@Valid @RequestBody PasteDTO pasteDTO){
        Paste paste = pasteBinService.createPaste(pasteDTO);
        return ResponseEntity
                .status(CREATED)
                .header("Location", "/api/v1/" + paste.getId())
                .body(paste);
    }

    @PostMapping("/preSignedUrl")
    public ResponseEntity<String> getPreSignedUrl(@RequestBody PresignedDTO presignedDTO) {

        String filename = presignedDTO.getFilename();
        UUID uuid = UUID.randomUUID();
        String presignedURL = pasteBinService.getPresignedURL(filename, uuid);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("x-filename", filename)
                .body(presignedURL);
    }


    @GetMapping("/{shortUrl}")
    public ResponseEntity<Paste> getPasteByUrl(@PathVariable("shortUrl") String shortUrl){
        Paste paste = pasteBinService.getPasteByUrl(shortUrl);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paste);
    }
}
