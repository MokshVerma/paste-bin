package com.moksh.pastebin.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class Paste {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "short_link_suffix")
    String shortLinkSuffix;

    @Column(name = "ttl")
    Long ttl;

    @Column(name = "content_url")
    String contentUrl;

    @Column(name = "created_at")
    Long createdAt;

    @Column(name = "updated_at")
    Long updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now().getEpochSecond();
    }

    protected void onUpdate() {
        this.updatedAt = Instant.now().getEpochSecond();
    }



}
