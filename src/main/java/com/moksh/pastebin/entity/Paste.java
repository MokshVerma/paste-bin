package com.moksh.pastebin.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Paste extends Meta {

    @Id
    private UUID id;

    @Column(name = "short_link_suffix")
    String shortLinkSuffix;

    @Column(name = "ttl")
    Long ttl;

    @Column(name = "content_url")
    String contentUrl;

}
