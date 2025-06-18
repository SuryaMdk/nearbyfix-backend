package com.sss.nearbyfix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sss.nearbyfix.model.ServiceRequest;
import com.sss.nearbyfix.service.ServiceRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService requestService;

    @PostMapping
    public ResponseEntity<ServiceRequest> create(@RequestBody ServiceRequest request) {
        return new ResponseEntity<>(requestService.createRequest(request), HttpStatus.CREATED);
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<ServiceRequest>> getByProvider(@PathVariable Long providerId) {
        return new ResponseEntity<>(requestService.getRequestsByProvider(providerId), HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ServiceRequest> updateStatus(@PathVariable Long id, @RequestParam String status) {
        ServiceRequest updated = requestService.updateStatus(id, status);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
