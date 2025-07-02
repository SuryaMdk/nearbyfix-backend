package com.sss.nearbyfix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.sss.nearbyfix.model.ServiceRequest;
import com.sss.nearbyfix.service.ServiceRequestService;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService requestService;

    @PostMapping("/register")
    public ResponseEntity<?> createRequest(@RequestBody ServiceRequest request) {
        return new ResponseEntity<>(requestService.createRequest(request), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getRequestsByUser(@PathVariable Long userId) {
        List<ServiceRequest> requests = requestService.findByUserId(userId);
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/type/{serviceType}")
    public ResponseEntity<?> getRequestByType(@PathVariable String serviceType){
    	List<ServiceRequest> requests = requestService.findByServiceTypeAndStatus(serviceType, "pending");
    	return ResponseEntity.ok(requests);
    }
    
    @PutMapping("/{id}/accept")
    public ResponseEntity<?> acceptRequest(@PathVariable Long id, @RequestParam Long providerId){
    	Optional<ServiceRequest> optional = requestService.findById(id);
    	if(optional.isPresent()) {
    		ServiceRequest req = optional.get();
    		req.setStatus("accepted");
    		req.setProviderId(providerId);
    		requestService.save(req);
    		return ResponseEntity.ok("Accepted");
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found");
    	}
    }
    
    @PutMapping("/{id}/complete")
    public ResponseEntity<?> completeRequest(@PathVariable Long id){
    	Optional<ServiceRequest> optional = requestService.findById(id);
    	if(optional.isPresent()) {
    		ServiceRequest req = optional.get();
    		req.setStatus("completed");
    		requestService.save(req);
    		return ResponseEntity.ok("Marked as Completed");
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found");	
    	}
    }
    
    @GetMapping("/provider/{providerId}")
    public ResponseEntity<?> getRequestsByProvider(@PathVariable Long providerId){
    	List<ServiceRequest> requests = requestService.findByProviderId(providerId);
    	return ResponseEntity.ok(requests);
    }
}
