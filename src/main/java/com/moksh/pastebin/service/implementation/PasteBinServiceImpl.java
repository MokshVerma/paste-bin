package com.moksh.pastebin.service.implementation;

import com.moksh.pastebin.entity.Paste;
import com.moksh.pastebin.entity.request.PasteDTO;
import com.moksh.pastebin.repository.PasteRepository;
import com.moksh.pastebin.service.PasteBinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static com.moksh.pastebin.utils.Constants.GCS_BASE_URL;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class PasteBinServiceImpl implements PasteBinService {


    private final PasteRepository pasteRepository;

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

    @Override
    public String getPresignedURL(String filename, UUID uuid){
        return "supp";
    }

    @Override
    public Paste createPaste(PasteDTO pasteDTO) {
//        If already exist with same name, then only save in DB

//        if(!pasteContentAlreadyExists(pasteDTO.getFileName())) {
//            throw new InvalidPasteException("Paste content already exists");
//        }

        Paste paste = new Paste();
        paste.setId(pasteDTO.getId());
        paste.setTtl(pasteDTO.getTtl());

        String shortLinkSuffix = RandomStringUtils.randomAlphanumeric(8);
        paste.setShortLinkSuffix(shortLinkSuffix);

        String contentUrl = GCS_BASE_URL + pasteDTO.getFileName();
        paste.setContentUrl(contentUrl);

        pasteRepository.save(paste);
        return paste;
    }
}
