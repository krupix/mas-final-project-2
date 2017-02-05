package pl.krupix.mas.pgauto.api.util;

/**
 * Created by krupix on 05.02.2017.
 */
public class PriceCalculator {

    private static final int TAX = 24;

    public static Integer getGrossPrice(Integer netPrice) {
        return (netPrice * (100 + TAX)) / 100;
    }
}

