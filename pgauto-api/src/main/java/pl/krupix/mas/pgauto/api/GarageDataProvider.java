package pl.krupix.mas.pgauto.api;

import pl.krupix.mas.pgauto.api.dto.garage.GarageEmployeeRepairDetailsDTO;
import pl.krupix.mas.pgauto.api.dto.repair.*;
import pl.krupix.mas.pgauto.api.dto.vehicle.VehicleRepairDetailsDTO;

import java.util.List;

/**
 * Created by krupix on 05.02.2017.
 */
public interface GarageDataProvider {

    List<WarehouseDTO> getWarehouseList();

    WarehouseDTO getWarehouseByName(String name);

    PartDTO getPartByName(String partName);

    List<RepairDTO> getRepairsList();

    List<VehicleRepairDetailsDTO> getVehicelRepairlDetails();

    void savePartsOrder(PartsOrderDTO partsOrderDTO, VehicleRepairDetailsDTO orderedRepair, InvoiceDTO invoiceDTO);

}
