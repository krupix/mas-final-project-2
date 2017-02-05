package pl.krupix.mas.pgauto.api.dto.vehicle;

import pl.krupix.mas.pgauto.api.exception.VINNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by krupix on 02.02.2017.
 */
public abstract class VehicleDTO {

    private String manufacturer;

    private String model;

    private String registrationNumber;

    private Integer engingeCapacity;

    private Long mileage;

    private String fuelType;

    private Date productionDate;

    private String VIN;

    private List<VehicleRepairDetailsDTO> vehicleRepairDetailsDTOList = new ArrayList<VehicleRepairDetailsDTO>();


    public VehicleDTO(String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.engingeCapacity = engingeCapacity;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.productionDate = productionDate;
        this.VIN = VIN;
    }

    public String getVIN() throws VINNotFoundException {
        
        if (VIN != null) {
            return VIN;
        } else {
            throw new VINNotFoundException();
        }
        
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getEngingeCapacity() {
        return engingeCapacity;
    }

    public void setEngingeCapacity(Integer engingeCapacity) {
        this.engingeCapacity = engingeCapacity;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public List<VehicleRepairDetailsDTO> getVehicleRepairDetailsDTOList() {
        return vehicleRepairDetailsDTOList;
    }

    public void setVehicleRepairDetailsDTOList(List<VehicleRepairDetailsDTO> vehicleRepairDetailsDTOList) {
        this.vehicleRepairDetailsDTOList = vehicleRepairDetailsDTOList;
    }
}
