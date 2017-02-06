package pl.krupix.mas.pgauto.api.dto.repair;

import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;
import pl.krupix.mas.pgauto.api.util.PriceCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by krupix on 05.02.2017.
 */
public class PartsOrderDTO {

    private Integer netPrice;

    private List<PartDTO> partDTOList = new ArrayList<PartDTO>();

    private Map<String, InvoiceDTO> invoiceMap = new TreeMap<String, InvoiceDTO>();


    public void addInvoice(InvoiceDTO invoiceDTO) {

        if (!invoiceMap.containsKey(invoiceDTO.getNumber())) {
            invoiceMap.put(invoiceDTO.getNumber(), invoiceDTO);
            invoiceDTO.setPartsOrderDTO(this);
        }

    }

    public InvoiceDTO findInvoice(String number) throws ParameterNotFoundException {

        if (invoiceMap.containsKey(number)) {
            return invoiceMap.get(number);
        } else {
            throw new ParameterNotFoundException("invoice");
        }

    }


    public Integer getGrossPrice() {
        return PriceCalculator.getGrossPrice(netPrice);
    }

    public Integer getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Integer netPrice) {
        this.netPrice = netPrice;
    }

    public List<PartDTO> getPartDTOList() {
        return partDTOList;
    }

    public void setPartDTOList(List<PartDTO> partDTOList) {
        this.partDTOList = partDTOList;
    }

}


