package university.exceptions;

/**
 * Created by aleksandrnagorniy on 19.11.16.
 */
public class InvalidQueryParameterException extends RuntimeException {
    public InvalidQueryParameterException(String message) {
        super(message);
    }
}
