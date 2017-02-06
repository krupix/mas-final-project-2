package pl.krupix.mas.pgauto.api.dto.repair;

import pl.krupix.mas.pgauto.api.dto.vehicle.VehicleRepairDetailsDTO;
import pl.krupix.mas.pgauto.api.dto.garage.GarageEmployeeRepairDetailsDTO;
import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by krupix on 03.02.2017.
 */
public class RepairDTO {

    private static Integer repairIncomingsPercent = 10;

    private static Integer partsIncomingsPercent = 30;

    private Long id;

    private Integer netPrice;

    private RepairTypes type;

    private RepairStatuses status;

    private List<GarageEmployeeRepairDetailsDTO> garageEmployeeRepairDetailsDTOList = new ArrayList<GarageEmployeeRepairDetailsDTO>();

    private List<VehicleRepairDetailsDTO> vehicleRepairDetailDTOS = new ArrayList<VehicleRepairDetailsDTO>();

    private Map<String, InvoiceDTO> invoiceMap = new TreeMap<String, InvoiceDTO>();


    private void addInvoice(InvoiceDTO invoiceDTO) {

        if (!invoiceMap.containsKey(invoiceDTO.getNumber())) {
            invoiceMap.put(invoiceDTO.getNumber(), invoiceDTO);
            invoiceDTO.setRepairDTO(this);
        }

    }

    private InvoiceDTO findInvoice(String number) throws ParameterNotFoundException {

        if (invoiceMap.containsKey(number)) {
            return invoiceMap.get(number);
        } else {
            throw new ParameterNotFoundException("invoice");
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Integer netPrice) {
        this.netPrice = netPrice;
    }

    public RepairTypes getType() {
        return type;
    }

    public void setType(RepairTypes type) {
        this.type = type;
    }

    public RepairStatuses getStatus() {
        return status;
    }

    public void setStatus(RepairStatuses status) {
        this.status = status;
    }

    public List<GarageEmployeeRepairDetailsDTO> getGarageEmployeeRepairDetailsDTOList() {
        return garageEmployeeRepairDetailsDTOList;
    }

    public void setGarageEmployeeRepairDetailsDTOList(List<GarageEmployeeRepairDetailsDTO> garageEmployeeRepairDetailsDTOList) {
        this.garageEmployeeRepairDetailsDTOList = garageEmployeeRepairDetailsDTOList;
    }

    public List<VehicleRepairDetailsDTO> getVehicleRepairDetailDTOS() {
        return vehicleRepairDetailDTOS;
    }

    public void setVehicleRepairDetailDTOS(List<VehicleRepairDetailsDTO> vehicleRepairDetailDTOS) {
        this.vehicleRepairDetailDTOS = vehicleRepairDetailDTOS;
    }
}
