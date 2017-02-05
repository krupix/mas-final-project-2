package pl.krupix.mas.pgauto;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krupix.mas.pgauto.util.PeselUtil;

import java.text.ParseException;

/**
 * Created by krupix on 05.02.2017.
 */
public class PeselUtilTest {


    @Test
    public void getBirthTest() throws ParseException {
        Assert.assertEquals(PeselUtil.getBirthDate("930603089553"), PeselUtil.getDate("1993", "6", "3"));
    }

    @Test
    public void getAgeTest() throws ParseException {
        Assert.assertEquals((int) PeselUtil.getAge("93060308953"), (int) 24);
    }


}
