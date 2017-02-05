package pl.krupix.mas.pgauto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by krupix on 01.02.2017.
 */
public class Starter {

    public static void main(String[] agrs) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("/pgauto-ctx.xml");
        ApplicationContext ctx1 = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Controller controller = ctx1.getBean(Controller.class);

        controller.repoTest();
    }

}
