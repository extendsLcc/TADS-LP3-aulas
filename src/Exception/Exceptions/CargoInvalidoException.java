package Exception.Exceptions;

public class CargoInvalidoException extends BaseException {

    public CargoInvalidoException(String message) {
        super(message, SeverityLevel.CRITICAL);
    }
}
