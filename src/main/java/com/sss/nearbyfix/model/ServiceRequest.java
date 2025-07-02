package com.sss.nearbyfix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long providerId;
    private String serviceType;
    private String problemDescription;
    private Double latitude;
    private Double longitude;
	private String location;
    private String status;
    
    public ServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceRequest(Long id, Long userId, Long providerId, String serviceType, String problemDescription, String location,
			String status, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.userId = userId;
		this.providerId = providerId;
		this.serviceType = serviceType;
		this.problemDescription = problemDescription;
		this.location = location;
		this.status = status;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getProviderId() {
		return providerId;
	}
	
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
}
