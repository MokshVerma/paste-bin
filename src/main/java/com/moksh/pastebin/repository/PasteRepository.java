package com.moksh.pastebin.repository;

import com.moksh.pastebin.entity.Paste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PasteRepository extends CrudRepository<Paste, UUID> {

    Paste findByShortUrl(String url);
}
