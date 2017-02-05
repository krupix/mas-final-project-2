package pl.krupix.mas.pgauto.api.dto.repair;


import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;
import pl.krupix.mas.pgauto.api.util.PriceCalculator;

import java.util.Date;

/**
 * Created by krupix on 03.02.2017.
 */
public class InvoiceDTO {

    private Integer netPrice;

    private Date createDate;

    private String number;

    private String title;

    private RepairDTO repairDTO;

    private PartsOrderDTO partsOrderDTO;


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

    public RepairDTO getRepairDTO() throws ParameterNotFoundException {

        if (repairDTO != null) {
            return repairDTO;
        } else {
            throw new ParameterNotFoundException("repairDTO");
        }

    }

    public void setRepairDTO(RepairDTO repairDTO) {
        this.repairDTO = repairDTO;
    }

    public PartsOrderDTO getPartsOrderDTO() throws ParameterNotFoundException {

        if (partsOrderDTO != null) {
            return partsOrderDTO;
        } else {
            throw new ParameterNotFoundException("parstOrder");
        }
    }

    public void setPartsOrderDTO(PartsOrderDTO partsOrderDTO) {
        this.partsOrderDTO = partsOrderDTO;
    }
}
