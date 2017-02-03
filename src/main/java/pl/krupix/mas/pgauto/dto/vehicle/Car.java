package pl.krupix.mas.pgauto.dto.vehicle;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import lombok.Data;

/**
 * Created by krupix on 03.02.2017.
 */
@Data
public class Car extends Vehicle {

    private BodyType bodyType;

}
