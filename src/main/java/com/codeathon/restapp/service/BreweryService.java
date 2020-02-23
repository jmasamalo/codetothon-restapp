package com.codeathon.restapp.service;

import com.codeathon.restapp.model.Brewery;
import com.codeathon.restapp.model.BreweryListResponse;
import com.codeathon.restapp.model.BreweryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreweryService {
    private static final String BREWERIES_KEY = "breweries?key=";
    private static final String BREWERY = "brewery/";
    private static final String KEY = "?key=";
    @Autowired
    protected RestTemplate restTemplate;

    @Value(value = "${url}")
    private String url;

    @Value(value = "${key}")
    private String key;

    public BreweryListResponse getBreweries() {
        return restTemplate.getForObject(url+BREWERIES_KEY+key, BreweryListResponse.class);

    }

    public BreweryResponse getBrewery(String id) {
        return restTemplate.getForObject(url+BREWERY+id+KEY+key, BreweryResponse.class);
    }


}
