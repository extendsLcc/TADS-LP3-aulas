package Exception.Exceptions;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BaseException extends Exception {

    private SeverityLevel severityLevel;

    public BaseException(String message, SeverityLevel severityLevel) {
        super(message);
        this.severityLevel = severityLevel;
    }

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    @Override
    public String toString() {
        String msg = "Erro:";
        msg += this.getMessage() + "\n";
        msg += this.getCause() + "\n";
        msg += "severity Level: " + this.getSeverityLevel() + "\n";
        msg += "Stack Trace: \n"
            + Arrays.stream(this.getStackTrace())
                .map(Objects::toString)
                .collect(Collectors.joining("\n"))
            + "\nEnd Stack Trace \n";
        return msg;
    }
}
