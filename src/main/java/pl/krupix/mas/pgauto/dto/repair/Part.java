package pl.krupix.mas.pgauto.dto.repair;

import lombok.Data;
import pl.krupix.mas.pgauto.util.PriceCalculator;

import java.util.List;

/**
 * Created by krupix on 03.02.2017.
 */
public class Part {

    private Integer netPrice;

    private String manufacturer;

    private List<String> includedElements;

    private Warehouse warehouse;



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

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
