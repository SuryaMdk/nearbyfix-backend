package com.sss.nearbyfix.controller;

import com.sss.nearbyfix.model.ServiceProvider;
import com.sss.nearbyfix.security.JwtUtil;
import com.sss.nearbyfix.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/providers")
@CrossOrigin
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService providerService;
    
    @Autowired 
    private JwtUtil jwtUtil;

    @GetMapping("/allproviders")
    public List<ServiceProvider> getAllProviders(){
    	return providerService.findAll();
    }
    
    @PostMapping("/register")
    public ResponseEntity<ServiceProvider> registerProvider(@RequestBody ServiceProvider provider) {
        return new ResponseEntity<>(providerService.registerProvider(provider), HttpStatus.CREATED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ServiceProvider>> getAvailable(@RequestParam String type) {
        return new ResponseEntity<>(providerService.getAvailableProviders(type), HttpStatus.OK);
    }
    
//    @PostMapping("/login")
//    public ResponseEntity<?> loginProvider(@RequestBody ServiceProvider serviceProvider){
//    	ServiceProvider existingServiceProvider = providerService.login(serviceProvider.getEmail(), serviceProvider.getPassword());
//    	if(existingServiceProvider != null) {
//    		return ResponseEntity.ok(existingServiceProvider);
//    	}else {
//    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//    	}
//    }
    
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        ServiceProvider provider = providerService.findByEmail(email);
        if (provider == null || !provider.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(email);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("provider", provider);

        return response;
    }
}
