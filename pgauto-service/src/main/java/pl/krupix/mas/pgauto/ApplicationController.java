package pl.krupix.mas.pgauto;


import lombok.Data;
import org.apache.log4j.Logger;
import pl.krupix.mas.pgauto.api.dto.repair.*;
import pl.krupix.mas.pgauto.api.dto.vehicle.VehicleRepairDetailsDTO;
import pl.krupix.mas.pgauto.api.util.PriceCalculator;
import pl.krupix.mas.pgauto.gui.ApplicationFrame;
import pl.krupix.mas.pgauto.orm.domain.Invoice;

import javax.inject.Inject;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by krupix on 05.02.2017.
 */
@Data
public class ApplicationController {

    private static transient Logger logger = Logger.getLogger(ApplicationController.class);

    @Inject
    private GarageDataProviderImpl garageDataProvider;

    private ApplicationFrame view;


    private PartDTO orderedPart;
    private Integer orderedCount;
    private VehicleRepairDetailsDTO orderedRepair;

    public ApplicationController() {
        view = new ApplicationFrame();

    }

    public void init() {


        List<WarehouseDTO> warehouseDTOList = garageDataProvider.getWarehouseList();

        for (WarehouseDTO warehouseDTO : warehouseDTOList) {
            view.getWarehousesComboBox().addItem(warehouseDTO.getName());
        }

        view.getWarehouseNameLabel().setText(warehouseDTOList.get(0).getName());

        if (warehouseDTOList.get(0).getAdressDataDTO() != null) {
            view.getWarehouseAdressLabel().setText(warehouseDTOList.get(0).getAdressDataDTO().getStreet() + " " + warehouseDTOList.get(0).getAdressDataDTO().getHouseNumber() + ", " + warehouseDTOList.get(0).getAdressDataDTO().getZipCode() + " " + warehouseDTOList.get(0).getAdressDataDTO().getCity());
        }

        if (warehouseDTOList.get(0).getContactDataDTO() != null) {
            view.getWarehouseContactLabel().setText("email: " + warehouseDTOList.get(0).getContactDataDTO().getEmail());
            view.getWarehousePhoneLabel().setText("telefon: " + warehouseDTOList.get(0).getContactDataDTO().getPhoneNumber());
        }
        view.repaint();

        addListeners();

    }

    public void controll() {

    }

    private void addListeners() {

        view.getViewPartsCatalogButton().addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                logger.info("Action: OPEN PARTS TAB");

                WarehouseDTO warehouseDTO = garageDataProvider.getWarehouseByName((String)view.getWarehousesComboBox().getSelectedItem());
                List<VehicleRepairDetailsDTO> vehicelRepairlDetails = garageDataProvider.getVehicelRepairlDetails();
                view.initPartsCatalogView(warehouseDTO);

                for (VehicleRepairDetailsDTO dto : vehicelRepairlDetails) {
                    view.getChooseRepair().addItem(dto.getVehicleDTO().getManufacturer() + " " + dto.getVehicleDTO().getRegistrationNumber());
                }

                addListeners();
                view.revalidate();
                view.repaint();
            }

        });

        view.getBackButton().addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   logger.info("Action: BACK");
                   view.initWarehouseTabComponents();

                   orderedPart = null;
                   orderedCount = null;
                   init();
                   view.revalidate();
                   view.repaint();
                   }
           }

        );


        if (view.getPartsTable() != null &&  view.getPartsTable().getSelectionModel() != null ) {

            view.getPartsTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {

                    String partName = (String) view.getPartsTable().getModel().getValueAt(view.getPartsTable().getSelectedRow(), 0);

                    logger.info("got part: " + partName);
                    PartDTO partDTO = garageDataProvider.getPartByName(partName);

                    view.getPartNameLabel().setText("Nazwa: " + partDTO.getManufacturer());
                    view.getPartNetPriceLabel().setText("Cena netto: " + ((float)partDTO.getNetPrice())/100 + " zł");
                    view.getPartBruttoPriceLabel().setText("Cena brutto: " + ((float)PriceCalculator.getGrossPrice(partDTO.getNetPrice()))/100 + " zł");
                    view.repaint();
                }
            });

        }


        if (view.getPlaceOrderButton() != null) {

            view.getPlaceOrderButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String partName = (String) view.getPartsTable().getModel().getValueAt(view.getPartsTable().getSelectedRow(), 0);

                    logger.info("got part: " + partName);
                    PartDTO partDTO = garageDataProvider.getPartByName(partName);
                    Integer count = Integer.parseInt(view.getCountTextArea().getText());

                    List<VehicleRepairDetailsDTO> vehicelRepairlDetails = garageDataProvider.getVehicelRepairlDetails();

                    for (VehicleRepairDetailsDTO dto : vehicelRepairlDetails) {
                        if ( ((String) view.getChooseRepair().getSelectedItem()).equals(dto.getVehicleDTO().getManufacturer() + " " + dto.getVehicleDTO().getRegistrationNumber())) {
                            orderedRepair = dto;
                            break;
                        }
                    }



                    view.initOrderConfirmView(partDTO, count, orderedRepair.getVehicleDTO().getManufacturer() + " " + orderedRepair.getVehicleDTO().getRegistrationNumber());
                    view.repaint();
                    addListeners();
                    orderedPart = partDTO;
                    orderedCount = count;

                }
            });

        }

        if (view.getConfirmOrderButton() != null) {

            view.getConfirmOrderButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    PartsOrderDTO partsOrderDTO = new PartsOrderDTO();

                    for (int i = 0; i < orderedCount; i++) {
                        partsOrderDTO.getPartDTOList().add(orderedPart);
                    }

                    partsOrderDTO.setNetPrice(orderedCount * orderedPart.getNetPrice());

                    InvoiceDTO invoiceDTO = new InvoiceDTO();
                    invoiceDTO.setNetPrice(partsOrderDTO.getNetPrice());
                    invoiceDTO.setCreateDate(new Date() );
                    invoiceDTO.setNumber((new Random().nextInt(10000) +1) + "");
                    invoiceDTO.setPartsOrderDTO(partsOrderDTO);
                    invoiceDTO.setTitle("Faktura za zamowienie czesci do: " + orderedRepair.getVehicleDTO().getRegistrationNumber());

                    partsOrderDTO.addInvoice(invoiceDTO);

                    garageDataProvider.savePartsOrder(partsOrderDTO, orderedRepair, invoiceDTO);

                    logger.info("ORDERD PLACED");
                    logger.info("Action: BACK");
                    view.initWarehouseTabComponents();

                    orderedPart = null;
                    orderedCount = null;
                    init();
                    view.revalidate();
                    view.repaint();

                }
            });

        }


        if (view.getWarehousesComboBox() != null) {

            view.getWarehousesComboBox().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String warehouseName = (String) view.getWarehousesComboBox().getSelectedItem();

                    WarehouseDTO warehouseDTO = garageDataProvider.getWarehouseByName(warehouseName);
                    view.getWarehouseNameLabel().setText(warehouseDTO.getName());

                    if (warehouseDTO.getAdressDataDTO() != null) {
                        view.getWarehouseAdressLabel().setText(warehouseDTO.getAdressDataDTO().getStreet() + " " + warehouseDTO.getAdressDataDTO().getHouseNumber() + ", " + warehouseDTO.getAdressDataDTO().getZipCode() + " " + warehouseDTO.getAdressDataDTO().getCity());
                    }

                    if (warehouseDTO.getContactDataDTO() != null) {
                        view.getWarehouseContactLabel().setText("email: " + warehouseDTO.getContactDataDTO().getEmail());
                        view.getWarehousePhoneLabel().setText("telefon: " + warehouseDTO.getContactDataDTO().getPhoneNumber());
                    }

                    view.revalidate();
                    view.repaint();
                }
            });
        }

    }



}