package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Url;
import com.example.demo.repository.UrlRepository;
import com.example.demo.utils.Base62Handler;

@Service 
public class UrlShortenerService {
    
    UrlRepository urlRepository;
    UrlShortenerService(UrlRepository repo){
        this.urlRepository = repo;

    }
    public Url create(String oldUrl){
        
        Url savedUrl = new Url(oldUrl);
        urlRepository.saveAndFlush(savedUrl);
        String newUrl = Base62Handler.encode(savedUrl.getId(), oldUrl);
        savedUrl.setNewUrl(newUrl);

        return urlRepository.save(savedUrl);

        
    }
    public String access(String url) {
        return urlRepository.getByShortUrl(url).getOriginalUrl();
    }

    
}
