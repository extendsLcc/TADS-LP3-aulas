package Exception.Exceptions;

import java.util.Arrays;

public abstract class BaseException extends Exception {

    public BaseException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        String msg = "Erro:";
        msg += this.getMessage() + "\n";
        msg += this.getCause() + "\n";
        msg += Arrays.asList(this.getStackTrace()) + "\n";
        return msg;
    }
}
