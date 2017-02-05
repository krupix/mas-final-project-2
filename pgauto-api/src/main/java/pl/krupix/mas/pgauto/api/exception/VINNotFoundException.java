package pl.krupix.mas.pgauto.api.exception;

/**
 * Created by krupix on 05.02.2017.
 */
public class VINNotFoundException extends ParameterNotFoundException {

    public VINNotFoundException() {
    }

    public VINNotFoundException(String message) {
        super(message);
    }

}