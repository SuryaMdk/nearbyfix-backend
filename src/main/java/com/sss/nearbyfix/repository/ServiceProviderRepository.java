package com.sss.nearbyfix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sss.nearbyfix.model.ServiceProvider;

public interface ServiceProviderRepository  extends JpaRepository<ServiceProvider, Long> {
    List<ServiceProvider> findByServiceTypeAndIsAvailable(String type, Boolean isAvailable);
    
    ServiceProvider findByEmailAndPassword(String email, String password);

	ServiceProvider findByEmail(String email);
}