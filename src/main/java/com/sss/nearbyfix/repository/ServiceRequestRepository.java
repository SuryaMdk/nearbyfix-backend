package com.sss.nearbyfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.sss.nearbyfix.model.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
	List<ServiceRequest> findByUserId(Long userId);

	List<ServiceRequest> findByserviceTypeAndStatus(String serviceType, String status);

	List<ServiceRequest> findByProviderId(Long providerId);
}