package com.sss.nearbyfix.controller;

import com.sss.nearbyfix.model.ServiceProvider;
import com.sss.nearbyfix.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
@CrossOrigin
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService providerService;

    @PostMapping("/register")
    public ResponseEntity<ServiceProvider> registerProvider(@RequestBody ServiceProvider provider) {
        return new ResponseEntity<>(providerService.registerProvider(provider), HttpStatus.CREATED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ServiceProvider>> getAvailable(@RequestParam String type) {
        return new ResponseEntity<>(providerService.getAvailableProviders(type), HttpStatus.OK);
    }
}
