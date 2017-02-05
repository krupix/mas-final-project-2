package pl.krupix.mas.pgauto.api.exception;

/**
 * Created by krupix on 05.02.2017.
 */
public class IncorrectDateException extends Exception {
    
    public IncorrectDateException () {
    }

    public IncorrectDateException (String message) {
        super(message);
    }

}


