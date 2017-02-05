package pl.krupix.mas.pgauto;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krupix.mas.pgauto.api.util.PriceCalculator;

/**
 * Created by krupix on 05.02.2017.
 */
public class PriceCalculatorTest {
    
    @Test
    public void getNetPriceTest() {

        Integer netPrice = 100;
        Integer expectedGrossPrice = 124;

        Integer grossPrice = PriceCalculator.getGrossPrice(netPrice);

        Assert.assertEquals(grossPrice, expectedGrossPrice);

    }
}
