package pl.krupix.mas.pgauto.dto.repair;

import pl.krupix.mas.pgauto.util.PriceCalculator;

import java.util.List;

/**
 * Created by krupix on 05.02.2017.
 */
public class PartsOrder {

    private Integer netPrice;

    private List<Part> partList;


    public Integer getGrossPrice() {
        return PriceCalculator.getGrossPrice(netPrice);
    }

    public Integer getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Integer netPrice) {
        this.netPrice = netPrice;
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

}


