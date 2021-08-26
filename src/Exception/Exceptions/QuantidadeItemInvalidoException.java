package Exception.Exceptions;

public class QuantidadeItemInvalidoException extends BaseException {

    public QuantidadeItemInvalidoException(String message) {
        super(message, SeverityLevel.INFO);
    }

}
