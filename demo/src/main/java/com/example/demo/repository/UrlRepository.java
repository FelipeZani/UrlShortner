package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Url;

public interface UrlRepository  extends JpaRepository<Url, UUID> {

    @Query(value = "SELECT * FROM url WHERE new_url = :url ORDER BY id ASC LIMIT 1",nativeQuery = true)
    Url getByShortUrl(@Param("url") String url);
    
}
