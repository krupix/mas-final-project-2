package pl.krupix.mas.pgauto;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.krupix.mas.pgauto.api.util.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
public class DateUtilTest {


    private final static String DATE_PATTER = "yyyymmdd";


    @Test
    public void calculateDaysDiffTest() throws ParseException {

        DateFormat format = new SimpleDateFormat(DATE_PATTER);

        Date date1 = format.parse("20170101");
        Date date2 = format.parse("20170110");

        Assert.assertEquals(DateUtil.calculateDaysDiff(date1, date2), 9);

    }
}
