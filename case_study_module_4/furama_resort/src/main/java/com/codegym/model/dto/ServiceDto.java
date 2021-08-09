package com.codegym.model.dto;

import com.codegym.model.entity.RentType;
import com.codegym.model.entity.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ServiceDto implements Validator {
    private String serviceId;

    @NotEmpty(message = "Input please!!!")
    private String serviceName;

    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;

    @NotEmpty(message = "Input please!!!")
    private String standardRoom;

    @NotEmpty(message = "Input please!!!")
    private String descriptionOtherConvenience;

    private double poolArea;
    private int numberOfFloor;

    public ServiceDto() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        String serviceId = serviceDto.getServiceId();
        int serviceArea = serviceDto.getServiceArea();
        double serviceCost = serviceDto.getServiceCost();
        int serviceMaxPeople = serviceDto.getServiceMaxPeople();
        double poolArea = serviceDto.getPoolArea();
        int numberOfFloor = serviceDto.getNumberOfFloor();
        ValidationUtils.rejectIfEmpty(errors, "serviceId", "serviceId.empty");
        if (!serviceId.matches("(^[D][V][-]([0-9]{4})$)")){
            errors.rejectValue("serviceId", "serviceId.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "serviceArea", "serviceArea.matches");
        if (serviceArea<=0){
            errors.rejectValue("serviceArea", "serviceArea.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "serviceCost", "serviceCost.matches");
        if (serviceCost<=0){
            errors.rejectValue("serviceCost", "serviceCost.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "serviceMaxPeople", "serviceMaxPeople.matches");
        if (serviceMaxPeople<=0){
            errors.rejectValue("serviceMaxPeople", "serviceMaxPeople.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "poolArea", "poolArea.matches");
        if (poolArea<=0){
            errors.rejectValue("poolArea", "poolArea.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "numberOfFloor", "numberOfFloor.matches");
        if (numberOfFloor<0){
            errors.rejectValue("numberOfFloor", "numberOfFloor.matches");
        }


    }
}
