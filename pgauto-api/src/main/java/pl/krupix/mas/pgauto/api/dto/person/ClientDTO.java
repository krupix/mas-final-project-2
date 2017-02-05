package pl.krupix.mas.pgauto.api.dto.person;

import com.sun.jdi.ObjectCollectedException;
import pl.krupix.mas.pgauto.api.dto.vehicle.MotocycleDTO;
import pl.krupix.mas.pgauto.api.dto.vehicle.VehicleDTO;
import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;
import pl.krupix.mas.pgauto.api.dto.vehicle.CarDTO;

import java.util.HashSet;
import java.util.Vector;

/**
 * Created by krupix on 04.02.2017.
 */
public class ClientDTO extends PersonDTO {

    private static HashSet<VehicleDTO> allVehicleDTOS = new HashSet<VehicleDTO>();

    private Vector<VehicleDTO> vehicleDTOS = new Vector<VehicleDTO>();

    private String comanyName;

    private String NIP;


    public Integer getRegularCustomerDiscount() {

        Integer repairsCount = 0;

        for (VehicleDTO vehicleDTO : vehicleDTOS) {

            if (vehicleDTO.getVehicleRepairDetailsDTOList() != null) {
                repairsCount += vehicleDTO.getVehicleRepairDetailsDTOList().size();
            }

        }

        if (repairsCount > 15) {
            return 10;
        } else if (repairsCount > 5) {
            return 5;
        } else {
            return 0;
        }

    }

    public void addCar(CarDTO carDTO) {

        if (!vehicleDTOS.contains(carDTO)) {

            if (allVehicleDTOS.contains(carDTO)) {
                throw new ObjectCollectedException("CarDTO are already added to other client: " + carDTO);
            }

            vehicleDTOS.add(carDTO);
            allVehicleDTOS.add(carDTO);
        }

    }

    public void addMotocycle(MotocycleDTO motocycleDTO) {

        if (!vehicleDTOS.contains(motocycleDTO)) {

            if (allVehicleDTOS.contains(motocycleDTO)) {
                throw new ObjectCollectedException("MotocycleDTO are already added to other client: " + motocycleDTO);
            }

            vehicleDTOS.add(motocycleDTO);
            allVehicleDTOS.add(motocycleDTO);
        }

    }

    public static HashSet<VehicleDTO> getAllVehicleDTOS() {
        return allVehicleDTOS;
    }

    public static void setAllVehicleDTOS(HashSet<VehicleDTO> allVehicleDTOS) {
        ClientDTO.allVehicleDTOS = allVehicleDTOS;
    }

    public Vector<VehicleDTO> getVehicleDTOS() {
        return vehicleDTOS;
    }

    public void setVehicleDTOS(Vector<VehicleDTO> vehicleDTOS) {
        this.vehicleDTOS = vehicleDTOS;
    }

    public String getComanyName() throws ParameterNotFoundException {

        if (comanyName != null) {
            return comanyName;
        } else {
            throw new ParameterNotFoundException("companyName");
        }

    }

    public void setComanyName(String comanyName) {
        this.comanyName = comanyName;
    }

    public String getNIP() throws ParameterNotFoundException {

        if (NIP != null) {
            return NIP;
        } else {
            throw new ParameterNotFoundException("nip");
        }

    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

}
