/**
 * Simple exception for if the book with the given title is not found in the inventory.
 * @author Callum Anderson
 * @version 1.0
 */

public class BookNotFoundException extends Exception {

    /**
     * Default constructor for the exception providing it with a message.
     */

    public BookNotFoundException(){

        super("Book not Found.");

    }

}
