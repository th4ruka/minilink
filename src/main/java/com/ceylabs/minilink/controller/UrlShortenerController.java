package com.ceylabs.minilink.controller;

import com.ceylabs.minilink.model.Url;
import com.ceylabs.minilink.service.UrlShortenerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController //automatically discoverable by Spring Boot's component scanning mechanism.
@RequestMapping("/api/v1/")
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("shorten")
    public ResponseEntity<Url> shortenUrl(@RequestBody String originalUrl) {
        try{
            Url shortenedUrl = urlShortenerService.shortenUrl(originalUrl);
            return ResponseEntity.status(HttpStatus.CREATED).body(shortenedUrl);
        }catch (MalformedURLException e){
            Url errorUrl = new Url();
            errorUrl.setShortCode("error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorUrl);
        }

    }

    @GetMapping("{shortCode}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortCode) {
        //return a response entity with any type of body using <?>
        try{
            String originalUrl = urlShortenerService.getOriginalUrl(shortCode);
//            return ResponseEntity.status(HttpStatus.FOUND).header("Location", originalUrl).build();
            return ResponseEntity.status(HttpStatus.FOUND).body(originalUrl);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}

