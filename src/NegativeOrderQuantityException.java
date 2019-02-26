/**
 * Simple exception for if an order is made and it orders negative books.
 * @author Callum Anderson
 * @version 1.0
 */

public class NegativeOrderQuantityException extends Exception {

    /**
     * Default constructor for the exception providing it with a message.
     */

    public NegativeOrderQuantityException(){

        super("Negative order quantity.");

    }

}
