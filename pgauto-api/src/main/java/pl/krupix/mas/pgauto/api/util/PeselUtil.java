package pl.krupix.mas.pgauto.api.util;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by krupix on 04.02.2017.
 */
public class PeselUtil {

    private static transient Logger logger = Logger.getLogger(PeselUtil.class);


    private final static String DATE_PATTER = "yyyymmdd";


    /*
        TODO: Validate Pesel
    */


    public static Date getBirthDate(String PESEL) throws ParseException {

        Integer year = getBirthYear(PESEL);
        Integer month = getBirthMonth(PESEL);
        Integer day = getBirthDay(PESEL);

        logger.info("created date: day " + day + ", month: " + month + ", year: " + year + " from pesel: " + PESEL);

        return getDate(year.toString(), month.toString(), day.toString());
    }

    public static Integer getAge(String PESEL) throws ParseException {

        Date birthDate = getBirthDate(PESEL);
        Integer age = getDiffYears(birthDate, new Date());

        logger.info("calculated date for pesel " + PESEL + " is " + age);

        return age;
    }

    public static Date getDate(String year, String month, String day) throws ParseException {

        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }

        if (Integer.parseInt(day) < 10) {
            day = "0" + day;
        }

        DateFormat format = new SimpleDateFormat(DATE_PATTER);
        return format.parse(year + month + day);

    }

    private static int getBirthYear(String PESEL) {

        int year;
        int month;

        year = 10 * Character.getNumericValue(PESEL.charAt(0));
        year += Character.getNumericValue(PESEL.charAt(1));
        month = 10 * Character.getNumericValue(PESEL.charAt(2));
        month += Character.getNumericValue(PESEL.charAt(3));

        if (month > 80 && month < 93) {
            year += 1800;
        } else if (month > 0 && month < 13) {
            year += 1900;
        } else if (month > 20 && month < 33) {
            year += 2000;
        } else if (month > 40 && month < 53) {
            year += 2100;
        } else if (month > 60 && month < 73) {
            year += 2200;
        }

        return year;
    }

    private static int getBirthMonth(String PESEL) {

        int month;

        month = 10 * Character.getNumericValue(PESEL.charAt(2));
        month += Character.getNumericValue(PESEL.charAt(3));

        if (month > 80 && month < 93) {
            month -= 80;
        } else if (month > 20 && month < 33) {
            month -= 20;
        } else if (month > 40 && month < 53) {
            month -= 40;
        } else if (month > 60 && month < 73) {
            month -= 60;
        }

        return month;
    }

    private static int getBirthDay(String PESEL) {

        int day;
        day = 10 * Character.getNumericValue(PESEL.charAt(4));
        day += Character.getNumericValue(PESEL.charAt(5));

        return day;
    }

    public static int getDiffYears(Date from, Date to) {

        Calendar fromDate = getCalendar(from);
        Calendar toDate = getCalendar(to);

        int diff = toDate.get(Calendar.YEAR) - fromDate.get(Calendar.YEAR);

        if (fromDate.get(Calendar.MONTH) > toDate.get(Calendar.MONTH) ||
                (fromDate.get(Calendar.MONTH) == toDate.get(Calendar.MONTH) && fromDate.get(Calendar.DATE) > toDate.get(Calendar.DATE))) {
            diff--;
        }

        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }


}
