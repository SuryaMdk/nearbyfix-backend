package com.sss.nearbyfix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.nearbyfix.model.ServiceRequest;
import com.sss.nearbyfix.repository.ServiceRequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestService {

    @Autowired
    private ServiceRequestRepository requestRepository;

    public ServiceRequest createRequest(ServiceRequest request) {
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    public List<ServiceRequest> getRequestsByProvider(Long providerId) {
        return requestRepository.findByProviderId(providerId);
    }

    public Optional<ServiceRequest> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    public ServiceRequest updateStatus(Long id, String status) {
        Optional<ServiceRequest> req = requestRepository.findById(id);
        if (req.isPresent()) {
            ServiceRequest r = req.get();
            r.setStatus(status.toUpperCase());
            return requestRepository.save(r);
        }
        return null;
    }
}
