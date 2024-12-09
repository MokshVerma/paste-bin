package com.moksh.pastebin.service.implementation;

import com.moksh.pastebin.entity.Paste;
import com.moksh.pastebin.repository.PasteRepository;
import com.moksh.pastebin.service.PasteBinService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class PasteBinServiceImpl implements PasteBinService {


    private final PasteRepository pasteRepository;
    private static final Logger log = LoggerFactory.getLogger(PasteBinServiceImpl.class);

    @Override
    public Paste getPasteById(UUID pasteId) {

        Optional<Paste> optionalPaste = pasteRepository.findById(pasteId);
        if(optionalPaste.isEmpty()) {
            log.error("Not Found");
            throw new NoSuchElementException(String.format("Paste not found for Id: %s", pasteId));
        }

        return optionalPaste.get();
    }

    @Override
    public Paste getPasteByUrl(String shortUrl) {
        return pasteRepository.findByShortUrl(shortUrl);
    }
}
