package pl.krupix.mas.pgauto.gui;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.repair.PartDTO;
import pl.krupix.mas.pgauto.api.dto.repair.WarehouseDTO;
import pl.krupix.mas.pgauto.api.util.PriceCalculator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Data
public class ApplicationFrame extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel repairsTab, clientsTab, workersTab, warehouseTab;

    private JPanel warehousePanel, leftWarehousePanel, rightWarehousePanel;

    private JLabel chooseWarehouseLabel;
    private JComboBox<String> warehousesComboBox;
    private JButton editWarehouseButton, addWarehouseButton, importPartsButton;

    private JLabel warehouseNameLabel, warehouseAdressLabel, warehouseContactLabel, warehousePhoneLabel, warehouseAdditionalInformationLabel;
    private JButton viewPartsCatalogButton;

    private JTextField searchPartTextArea, countTextArea;
    private JButton searchButton;
    private JButton backButton = new JButton("Wróć");
    private JTable partsTable;
    private JLabel partNameLabel;
    private JLabel partNetPriceLabel;
    private JLabel partBruttoPriceLabel;
    private JComboBox<String> chooseRepair;
    private JComboBox<Integer> chooseCount;
    private JLabel priceWithTaxLabel, priceWithoutTaxLabel, countLabel;
    private JPanel headerPanel, eastPanel, southPanel;
    private JButton placeOrderButton;
    private DefaultTableModel model;

    private JLabel summaryLabel;
    private JLabel summaryPartNameLabel;
    private JLabel summaryPartsCount;
    private JLabel totalNetPrice;
    private JLabel totalGrossPrice;
    private JLabel repairNameLabel;
    private JButton confirmOrderButton;
    private JPanel centerPanel;

    public ApplicationFrame() {
        super("PG Auto");
        initMainComponents();
        initTabs();
        initWarehouseTabComponents();
//        initPartsCatalogView();
    }

    private void initMainComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,100);
        setSize(600, 300);
        setResizable(false);
        setVisible(true);
    }

    public void initTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();

        repairsTab = new JPanel();
        clientsTab = new JPanel();
        workersTab = new JPanel();
        warehouseTab = new JPanel();

        tabbedPane.addTab("Hurtownie", warehouseTab); // todo zmienić na osstatnie miejsce
        tabbedPane.addTab("Naprawy", repairsTab);
        tabbedPane.addTab("Klienci", clientsTab);
        tabbedPane.addTab("Pracownicy", workersTab);

        add(tabbedPane);
    }

    public void initWarehouseTabComponents() {
        warehousePanel = new JPanel(new BorderLayout());
        warehouseTab.removeAll();
        initLeftWarehousePanel();
        initRightWarehousePanel();
        warehouseTab.add(leftWarehousePanel, BorderLayout.WEST);
        warehouseTab.add(rightWarehousePanel, BorderLayout.EAST);
    }

    private void initLeftWarehousePanel() {
        leftWarehousePanel = new JPanel(new GridLayout(5,1));

        chooseWarehouseLabel = new JLabel("Wybierz hurtownię:");
        leftWarehousePanel.add(chooseWarehouseLabel);

        warehousesComboBox = new JComboBox<String>();
        leftWarehousePanel.add(warehousesComboBox);

        editWarehouseButton = new JButton("Edytuj dane");
        addWarehouseButton = new JButton("Dodaj hurtownię");
        importPartsButton = new JButton("Importuj katalog części");
        leftWarehousePanel.add(editWarehouseButton);
        leftWarehousePanel.add(addWarehouseButton);
        leftWarehousePanel.add(importPartsButton);
    }

    private void initRightWarehousePanel() {
        rightWarehousePanel = new JPanel(new GridLayout(5,1));
        rightWarehousePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        warehouseNameLabel = new JLabel("Parts4You");
        warehouseAdressLabel = new JLabel("Adres:");
        warehouseContactLabel = new JLabel("Kontakt:");
        warehousePhoneLabel = new JLabel("Telefon:");
        rightWarehousePanel.add(warehouseNameLabel);
        rightWarehousePanel.add(warehouseAdressLabel);
        rightWarehousePanel.add(warehouseContactLabel);
        rightWarehousePanel.add(warehousePhoneLabel);

        viewPartsCatalogButton = new JButton("Przeglądaj katalog części");
        rightWarehousePanel.add(viewPartsCatalogButton);
    }

    public void initPartsCatalogView(WarehouseDTO warehouseDTO) {

        warehousePanel = new JPanel(new BorderLayout());

        southPanel = new JPanel();
        southPanel.add(backButton);

        warehousePanel.add(southPanel, BorderLayout.SOUTH);

        partsTable = new JTable();

        java.util.List<PartDTO> partList = warehouseDTO.getPartDTOS();

        model = (DefaultTableModel) partsTable.getModel();
        model.addColumn("Col1");
        model.addColumn("Col2");

        for (PartDTO part : partList) {
            System.out.print("Got: " + part.toRow());
            model.addRow(part.toRow());
        }

        partsTable.setModel(model);
        warehousePanel.add(partsTable, BorderLayout.CENTER);

        eastPanel = new JPanel(new GridLayout(7,1));
        partNameLabel = new JLabel("Nazwa: -");
        partNetPriceLabel = new JLabel("Cena netto: - zł");
        partBruttoPriceLabel = new JLabel("Cena brutto: - zł");
        placeOrderButton = new JButton("Zamów");
        countLabel = new JLabel("Ilość");
        countTextArea = new JTextField();
        chooseRepair = new JComboBox<String>();

        eastPanel.add(partNameLabel);
        eastPanel.add(partNetPriceLabel);
        eastPanel.add(partBruttoPriceLabel);
        eastPanel.add(countLabel);
        eastPanel.add(countTextArea);
        eastPanel.add(chooseRepair);
        eastPanel.add(placeOrderButton);

        warehousePanel.add(eastPanel, BorderLayout.EAST);
        warehouseTab.removeAll();
        warehouseTab.add(warehousePanel);
    }

    public void initOrderConfirmView(PartDTO partDTO, Integer count, String repairName) {

        warehousePanel = new JPanel(new BorderLayout());

        southPanel = new JPanel();
        southPanel.add(backButton);

        centerPanel = new JPanel(new GridLayout(7,1));

        summaryLabel = new JLabel("* Podsumowanie zamówienia *");
        summaryPartNameLabel = new JLabel("Nazwa: " + partDTO.getManufacturer());
        repairNameLabel = new JLabel("Naprawa: " + repairName);
        summaryPartsCount = new JLabel("Ilość: " + count);
        totalNetPrice = new JLabel("Cena netto: " + ((float) partDTO.getNetPrice() * count) / 100 + " zł");
        totalGrossPrice = new JLabel("Cena brutto: " + ((float) (PriceCalculator.getGrossPrice(partDTO.getNetPrice()) * count)) / 100 + " zł");
        confirmOrderButton = new JButton("Potwierdź zamówienie");

        centerPanel.add(summaryLabel);
        centerPanel.add(summaryPartNameLabel);
        centerPanel.add(repairNameLabel);
        centerPanel.add(summaryPartsCount);
        centerPanel.add(totalNetPrice);
        centerPanel.add(totalGrossPrice);
        centerPanel.add(confirmOrderButton);

        warehousePanel.add(centerPanel, BorderLayout.CENTER);

        warehousePanel.add(southPanel, BorderLayout.SOUTH);

        warehouseTab.removeAll();
        warehouseTab.add(warehousePanel);
    }

}
