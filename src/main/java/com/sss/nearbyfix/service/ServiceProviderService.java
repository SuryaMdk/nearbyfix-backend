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
}
