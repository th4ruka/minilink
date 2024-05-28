package com.ceylabs.minilink.service;


import com.ceylabs.minilink.model.Url;
import com.ceylabs.minilink.repository.UrlRepository;
import com.ceylabs.minilink.util.ApacheUrlValidatorAdapter;
import com.ceylabs.minilink.util.URLValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.Optional;

@Service
public class UrlShortenerService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlShortenerService(UrlRepository urlRepository) { //Dependency injection
        this.urlRepository = urlRepository;
    }

    public Url shortenUrl(String originalUrl) throws MalformedURLException {
        validateUrl(originalUrl);  // Ensure it's a valid URL
        String shortCode = generateUniqueShortCode();
        Url url = new Url(originalUrl, shortCode);
        return urlRepository.save(url);
    }

    public String getOriginalUrl(String shortCode) {
        Optional<Url> optionalUrl = urlRepository.findByShortCode(shortCode);
        if (optionalUrl.isPresent()) {
            return optionalUrl.get().getOriginalUrl();
        } else {
            throw new EntityNotFoundException("URL not found for short code: " + shortCode);
        }
    }

    private void validateUrl(String originalUrl) throws MalformedURLException {
        URLValidator validator = new ApacheUrlValidatorAdapter();
        validator.isValidUrl(originalUrl);
    }

    private String generateUniqueShortCode() {
        String shortCode;
        do {
            shortCode = generateRandomShortCode(6); // 6-character code
        } while (urlRepository.findByShortCode(shortCode).isPresent());
        return shortCode;
    }

    private String generateRandomShortCode(int length) {
        StringBuilder sb = new StringBuilder();
        String shortCodeChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Base62
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * shortCodeChars.length());
            sb.append(shortCodeChars.charAt(index));
        }
        return sb.toString();
    }
}

