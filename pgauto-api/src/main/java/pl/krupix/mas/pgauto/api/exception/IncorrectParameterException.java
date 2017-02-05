package pl.krupix.mas.pgauto.api.exception;

/**
 * Created by krupix on 05.02.2017.
 */
public class IncorrectParameterException extends Exception {

    public IncorrectParameterException () {
    }

    public IncorrectParameterException (String message) {
        super(message);
    }

}
