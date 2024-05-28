package com.ceylabs.minilink.util;

import java.net.MalformedURLException;

public interface URLValidator {
    boolean isValidUrl(String url) throws MalformedURLException;
}
