package pl.krupix.mas.pgauto.api.util;

import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
public class DateUtil {

    public static int calculateDaysDiff(Date date1, Date date2){
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static int getHoursDiff(Date date1, Date date2) {
        return (int) (date2.getTime() - date1.getTime()) / 1000 / 3600;
    }

}
