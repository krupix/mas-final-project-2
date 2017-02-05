package pl.krupix.mas.pgauto.exception;

/**
 * Created by krupix on 04.02.2017.
 */
public class PeselNotFoundException extends ParameterNotFoundException {

    public PeselNotFoundException() {
    }

    public PeselNotFoundException(String message) {
        super(message);
    }

}
