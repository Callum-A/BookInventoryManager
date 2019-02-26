/**
 * Class representing a book object with all of its relevant values.
 * @author Callum Anderson
 * @version 1.0
 */

public class Book implements Comparable<Book> {

    private final String title, isbn, author;
    private final int pages, releaseYear;
    private int quantity;
    private final double price;

    /**
     * Book contructor where we are given all of its values to be stored.
     * @param title The title of the book E.G. Game of Thrones.
     * @param author The writer of the book E.G. George R.R. Martin
     * @param releaseYear The year the book was publisher E.G. 1999
     * @param pages The amount of pages in the book E.G. 213
     * @param isbn The ISBN of the book E.G. 978-0199217946
     * @param quantity The quantity of the book in stock
     * @param price The price per unit of the book
     */

    public Book(String title, String author, int releaseYear, int pages, String isbn, int quantity, double price){

        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.pages = pages;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;

    }

    /**
     * Default constructor for a book given no values, purely for testing.
     */

    private Book(){

        this("DEFAULT","DEFAULT",0,0,"DEFAULT",0,0.0);

    }

    /**
     * Make a purchase on the book for a given amount.
     * @param orderQuantity The amount of books you would like to order.
     * @throws NegativeQuantityException If the amount causes the quantity to go into negatives throw the exception to
     * be dealt with later.
     */

    public void makePurchase(int orderQuantity) throws NegativeQuantityException{

        if(this.quantity - orderQuantity >= 0){

            this.quantity = this.quantity - orderQuantity;
            double orderValue = orderQuantity * this.price;

            System.out.println("You have ordered " + orderQuantity + " copies of "
                    + this.title + ".\nThis comes to a total cost of " + orderValue);

        }else{

            throw new NegativeQuantityException();

        }

    }

    /**
     * Order new stock of the book to increase the quantity.
     * @param orderQuantity The amount of new books you would like to order in.
     * @throws NegativeOrderQuantityException If you are ordering a negative amount throw an exception to be dealt with
     * later.
     */

    public void orderStock(int orderQuantity) throws NegativeOrderQuantityException{

        if(orderQuantity < 0){

            throw new NegativeOrderQuantityException();

        }else{

            this.quantity = this.quantity + orderQuantity;
            System.out.println("There are now " + this.quantity + " copies of " + this.title + " in stock.");

        }

    }

    /**
     * Calculates the current stock value of the book.
     * @return Returns the current stock value, price * quantity.
     */

    public double getCurrentStockValue(){

        return this.price * this.quantity;

    }

    /**
     * Accessor method for the title of the book.
     * @return Returns the title of the book as a string.
     */

    public String getTitle(){

        return title;

    }

    /**
     * Accessor method for the author of the book.
     * @return Returns the author of the book as a string.
     */

    public String getAuthor(){

        return author;

    }

    /**
     * Accessor method for the release year of the book.
     * @return Returns the release year as an integer.
     */

    public int getReleaseYear(){

        return releaseYear;

    }

    /**
     * Accessor method for the number of pages in the book.
     * @return Returns number of pages as an integer.
     */

    public int getPages(){

        return pages;

    }

    /**
     * Accessor method for the ISBN of the book.
     * @return Returns the ISBN as a string.
     */

    public String getIsbn(){

        return isbn;

    }

    /**
     * Accessor method for the quantity of the book in stock.
     * @return Returns the quantity of the book as an integer.
     */

    public int getQuantity(){

        return quantity;

    }

    /**
     * Accessor method for the price per unit of the book.
     * @return Returns the price of the book as a double.
     */

    public double getPrice(){

        return price;

    }

    /**
     * Returns all data of the book on one line separated by commas.
     * @return Returns the string of all data of the book separated by commas.
     */

    @Override
    public String toString(){

        return this.title + ","
                + this.author + ","
                + this.releaseYear + ","
                + this.pages + ","
                + this.isbn + ","
                + this.quantity + ","
                + this.price;

    }

    /**
     * Compares two books by their release year in ascending order.
     * @param b The book you will compare the other book to.
     * @return Returns an integer based on their difference in release year, this is used for sorting.
     */

    @Override
    public int compareTo(Book b){

        return this.releaseYear - b.releaseYear;

    }

}
