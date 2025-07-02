package com.sss.nearbyfix.service;

import com.sss.nearbyfix.model.ServiceProvider;
import com.sss.nearbyfix.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository providerRepository;

    public ServiceProvider registerProvider(ServiceProvider provider) {
        return providerRepository.save(provider);
    }

    public List<ServiceProvider> getAvailableProviders(String serviceType) {
        return providerRepository.findByServiceTypeAndIsAvailable(serviceType, true);
    }
    
    public ServiceProvider login(String email, String password) {
    	return providerRepository.findByEmailAndPassword(email,password);
    }

	public List<ServiceProvider> findAll() {
		// TODO Auto-generated method stub
		return providerRepository.findAll();
	}

	public ServiceProvider findByEmail(String email) {
		// TODO Auto-generated method stub
		return providerRepository.findByEmail(email);
	}
}
