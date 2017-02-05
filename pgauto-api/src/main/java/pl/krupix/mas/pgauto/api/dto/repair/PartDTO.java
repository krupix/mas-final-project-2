package pl.krupix.mas.pgauto.api.dto.repair;

import pl.krupix.mas.pgauto.api.util.PriceCalculator;

import java.util.List;

/**
 * Created by krupix on 03.02.2017.
 */
public class PartDTO {

    private Integer netPrice;

    private String manufacturer;

    private List<String> includedElements;

    private WarehouseDTO warehouseDTO;



    public Integer getGrossPrice() {
        return PriceCalculator.getGrossPrice(netPrice);
    }

    public Integer getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Integer netPrice) {
        this.netPrice = netPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<String> getIncludedElements() {
        return includedElements;
    }

    public void setIncludedElements(List<String> includedElements) {
        this.includedElements = includedElements;
    }

    public WarehouseDTO getWarehouseDTO() {
        return warehouseDTO;
    }

    public void setWarehouseDTO(WarehouseDTO warehouseDTO) {
        this.warehouseDTO = warehouseDTO;
    }
}
