package com.sss.nearbyfix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sss.nearbyfix.model.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    List<ServiceRequest> findByProviderId(Long providerId);
}