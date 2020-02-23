package com.codeathon.restapp.controller;

import com.codeathon.restapp.model.Brewery;
import com.codeathon.restapp.model.BreweryListResponse;
import com.codeathon.restapp.model.BreweryResponse;
import com.codeathon.restapp.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class BreweryController {
    @Autowired
    BreweryService  breweryService;

    @GetMapping("/breweries/")
    public ResponseEntity<List<Brewery>> getBreweriesData() {
        BreweryListResponse response = breweryService.getBreweries();
        if(response == null || response.getData() == null || response.getData().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response.getData().stream().sorted().collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/brewery/{id}")
    public ResponseEntity<Brewery> getBreweryById(@PathVariable String id) {
        BreweryResponse response =  breweryService.getBrewery(id);
        if(response == null || response.getData() == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);
    }
}
