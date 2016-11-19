package university.exceptions;

/**
 * Created by aleksandrnagorniy on 19.11.16.
 */
public class DBUnavailableException extends Throwable {
    public DBUnavailableException(String message) {
        super(message);
    }
}
