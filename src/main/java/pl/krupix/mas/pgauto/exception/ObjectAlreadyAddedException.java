package pl.krupix.mas.pgauto.exception;

/**
 * Created by krupix on 05.02.2017.
 */
public class ObjectAlreadyAddedException extends Exception {

    public ObjectAlreadyAddedException() {
    }

    public ObjectAlreadyAddedException(String message) {
        super(message);
    }

}
