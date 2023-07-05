package loto.Studio.lotoservicegames.config.exception;

public class ValueAlreadyExistsException extends ApiException{

    public ValueAlreadyExistsException() {
        super("VALUE ALREADY EXISTS IN DATABASE", 203);
    }
}
