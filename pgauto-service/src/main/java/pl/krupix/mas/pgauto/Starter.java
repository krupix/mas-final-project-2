package pl.krupix.mas.pgauto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by krupix on 01.02.2017.
 */
@ComponentScan({"pl.krupix.mas.pgauto"})
public class Starter {

    public static void main(String[] agrs) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("/pgauto-ctx.xml");

        ApplicationContext ctx1 = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        ApplicationController applicationController = ctx1.getBean(ApplicationController.class);

        applicationController.init();
        applicationController.controll();
    }

}
