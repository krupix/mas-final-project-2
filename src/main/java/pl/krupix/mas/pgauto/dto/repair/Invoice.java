package pl.krupix.mas.pgauto.dto.repair;


import pl.krupix.mas.pgauto.util.PriceCalculator;

import java.util.Date;
import java.util.TreeMap;

/**
 * Created by krupix on 03.02.2017.
 */
public class Invoice {

    private Integer netPrice;

    private Date createDate;

    private String number;

    private String title;


    public Integer getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Integer netPrice) {
        this.netPrice = netPrice;
    }

    public Integer getGrossPrice() {
        return PriceCalculator.getGrossPrice(netPrice);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
