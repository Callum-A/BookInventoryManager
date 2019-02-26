/**
 * Simple exception for if the book quantity will go into negative quantity.
 * @author Callum Anderson
 * @version 1.0
 */

public class NegativeQuantityException extends Exception {

    /**
     * Default constructor providing the exception with a message.
     */

    public NegativeQuantityException(){

        super("Negative quantity.");

    }

}
