package pl.krupix.mas.pgauto;

import pl.krupix.mas.pgauto.util.PeselUtil;

import java.text.ParseException;

/**
 * Created by krupix on 01.02.2017.
 */
public class Starter {

    public static void main(String[] agrs) {


        try {
            PeselUtil.getBirthDate("93060308953");
            PeselUtil.getAge("93060308953");
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
