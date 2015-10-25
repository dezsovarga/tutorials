package dezso.varga.teamgenerator.common.exceptions;

/**
 * Created by varga on 24.10.2015.
 */
public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message){
        super(message);
    }

    public PlayerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
