package pl.krupix.mas.pgauto;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krupix.mas.pgauto.api.dto.person.ClientDTO;
import pl.krupix.mas.pgauto.api.dto.repair.*;
import pl.krupix.mas.pgauto.api.GarageDataProvider;
import pl.krupix.mas.pgauto.api.dto.vehicle.VehicleRepairDetailsDTO;
import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;
import pl.krupix.mas.pgauto.orm.domain.*;
import pl.krupix.mas.pgauto.orm.repository.*;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by krupix on 05.02.2017.
 */
@Component
public class GarageDataProviderImpl implements GarageDataProvider {

    private static transient Logger logger = Logger.getLogger(GarageDataProviderImpl.class);


    @Inject
    private WarehouseRepository warehouseRepository;

    @Inject
    private PartRepository partRepository;

    @Inject
    private RepairRepository repairRepository;

    @Inject
    private RepairVehicleDetailsRepository repairVehicleDetailsRepository;

    @Inject
    private PartOrderRepository partOrderRepository;

    @Inject
    private OrderRepository orderRepository;



    public List<WarehouseDTO> getWarehouseList() {

        logger.info("getWarehouseList()");

        List<WarehouseDTO> result = new ArrayList<WarehouseDTO>();
        List<Warehouse> warehouses = warehouseRepository.findAll();

        for (Warehouse warehouse : warehouses) {
            result.add(warehouse.getDTO());
        }

        return result;
    }

    public WarehouseDTO getWarehouseByName(String name) {

        logger.info("getWarehouseByName (name=" + name + ")");

        Warehouse warehouse = warehouseRepository.findByName(name).get(0);
        List<Part> parts = partRepository.findByWarehouse(warehouse);

        WarehouseDTO result = warehouse.getDTO();
        List<PartDTO> partDTOS = new ArrayList<PartDTO>();

        for (Part part : parts) {
            partDTOS.add(part.getDTO());
        }

        result.setPartDTOS(partDTOS);
        return result;
    }

    public PartDTO getPartByName(String partName) {

        logger.info("getPartByName (partName=" + partName + ")");

        List<Part> parts = partRepository.findByManufacturer(partName);

        return parts.get(0).getDTO();
    }

    public List<RepairDTO> getRepairsList() {

        logger.info("getRepairsList()");

        List<RepairDTO> result = new ArrayList<RepairDTO>();
        List<Repair> repairs = repairRepository.findAll();

        for (Repair repair : repairs) {
            result.add(repair.getDTO()) ;
        }

        return result;
    }

    public List<VehicleRepairDetailsDTO> getVehicelRepairlDetails() {

        try {

            List<RepairVehicleDetails> repairVehicleDetails = repairVehicleDetailsRepository.findByStartDateBefore(new Date());
            List<VehicleRepairDetailsDTO> result = new ArrayList<VehicleRepairDetailsDTO>();

            for (RepairVehicleDetails repairVehicleDetail : repairVehicleDetails) {
                    result.add(repairVehicleDetail.getDTO());
            }

            return result;

        } catch (ParameterNotFoundException e) {
            logger.error("error:  " + e);
            e.printStackTrace();
        }

        return null;
    }

    public void savePartsOrder(PartsOrderDTO partsOrderDTO, VehicleRepairDetailsDTO orderedRepair, InvoiceDTO invoiceDTO) {

        logger.info("savePartsOrder (partsOrder=" + partsOrderDTO + ", orderedRepair=" + orderedRepair + ")");

        Order order = new Order();
        order.setNetPrice(partsOrderDTO.getNetPrice());
        order.setInvoice(new Invoice(invoiceDTO));
        order.setRepair(repairRepository.findOne(orderedRepair.getId()));
        orderRepository.save(order);

        for (PartDTO partDTO : partsOrderDTO.getPartDTOList()) {
            PartOrder partOrder = new PartOrder();
            partOrder.setOrder(order);
            partOrder.setPart(new Part(partDTO));
            partOrderRepository.save(partOrder);
        }


    }
}
