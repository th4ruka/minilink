package com.ceylabs.minilink.util;

import org.apache.commons.validator.UrlValidator;

import java.net.MalformedURLException;

public class ApacheUrlValidatorAdapter implements URLValidator{

    private final UrlValidator apacheValidator;

    public ApacheUrlValidatorAdapter(){
        this.apacheValidator = new UrlValidator();
    }

    @Override
    public boolean isValidUrl(String url) throws MalformedURLException {
        return apacheValidator.isValid(url);
    }
}
