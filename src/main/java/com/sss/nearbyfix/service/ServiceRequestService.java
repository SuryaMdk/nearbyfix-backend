package com.sss.nearbyfix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.sss.nearbyfix.model.ServiceRequest;
import com.sss.nearbyfix.repository.ServiceRequestRepository;

@Service
public class ServiceRequestService {

    @Autowired
    private ServiceRequestRepository requestRepository;

    public ServiceRequest createRequest(ServiceRequest request) {
        request.setStatus("Pending");
        return requestRepository.save(request);
    }

	public List<ServiceRequest> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return requestRepository.findByUserId(userId);
	}

	public List<ServiceRequest> findByServiceTypeAndStatus(String serviceType, String status) {
		// TODO Auto-generated method stub
		return requestRepository.findByserviceTypeAndStatus(serviceType, status);
	}

	public Optional<ServiceRequest> findById(Long id) {
		// TODO Auto-generated method stub
		return requestRepository.findById(id);
	}

	public void save(ServiceRequest req) {
		// TODO Auto-generated method stub
		requestRepository.save(req);
	}

	public List<ServiceRequest> findByProviderId(Long providerId) {
		// TODO Auto-generated method stub
		return requestRepository.findByProviderId(providerId);
	}

}
