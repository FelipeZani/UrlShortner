package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "url")
public class Url {


    @Id@GeneratedValue(strategy=GenerationType.UUID)
    UUID id ;
    @Column (nullable = false, length = 512)
    String originalUrl;
    @Column
    String newUrl;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp  
    LocalDateTime timeStamp;

    public Url(String originalUrl){
        this.originalUrl = originalUrl;
        this.newUrl = "";
    }
  public Url(){}
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
