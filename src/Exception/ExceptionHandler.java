package Exception;

import Exception.Exceptions.BaseException;

public class ExceptionHandler {

    public static void handleException(BaseException baseException) {

        switch ( baseException.getSeverityLevel() ) {
            case INFO -> System.out.println("Info exception, return info for user \n" + baseException);
            case WARNING -> System.out.println("Warning exception, return info for support \n" + baseException);
            case CRITICAL -> System.out.println("Critical exception,return info for developers \n" + baseException);
        }

    }

}
