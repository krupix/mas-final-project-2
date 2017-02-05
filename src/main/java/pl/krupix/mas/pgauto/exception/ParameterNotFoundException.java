package pl.krupix.mas.pgauto.exception;

/**
 * Created by krupix on 04.02.2017.
 */
public class ParameterNotFoundException extends Exception {

    public ParameterNotFoundException() {
    }

    public ParameterNotFoundException(String message) {
        super("Parameter not found: " + message);
    }

}
