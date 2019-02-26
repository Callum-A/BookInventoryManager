import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Object representing an inventory of books storing each book in a list, can be sorted and queried using the methods
 * provided.
 * @author Callum Anderson
 * @version 1.0
 */

public class Inventory {

    private final List<Book> bookInventory;

    /**
     * Default constructor for a book inventory creating an empty inventory.
     */

    public Inventory(){

        this.bookInventory = new ArrayList<>();

    }

    /**
     * Adds to the book inventory from a text file in the format provided.
     * @param filePath Path to find the txt file to read in
     */

    public void addToInventoryFromFile(String filePath){

        File file = new File(filePath);//file path for the file to read

        try{

            Scanner reader = new Scanner(file);//scanner to read the given file

            while(reader.hasNextLine()){//while not at the end of the file

                String line = reader.nextLine();//save the next line as a string

                String[] bookDetails = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                //split it by commas ignoring those in quotations

                /* Storing the book details in relevant variables and datatypes */

                String title = bookDetails[0];
                String author = bookDetails[1];
                int releaseYear = Integer.parseInt(bookDetails[2]);
                int pages = Integer.parseInt(bookDetails[3]);
                String isbn = bookDetails[4];
                int quantity = Integer.parseInt(bookDetails[5]);
                double price = Double.parseDouble(bookDetails[6]);

                //add the book to the inventory
                this.addToInventory(new Book(title, author, releaseYear, pages, isbn, quantity, price));

            }

        }catch(FileNotFoundException e){//if the file isn't found catch the exception

            System.out.println("File not found exception: " + e);//simply print the exception

        }

    }

    /**
     * Used to add a single book to an inventory.
     * @param b The book you would like to add to the inventory.
     */

    public void addToInventory(Book b){

        this.bookInventory.add(b);
        System.out.println("Title " + b.getTitle() + " has been added to the inventory.");

    }

    /**
     * Searches the inventory for a given book based on title.
     * @param title User defined title to check if there is a book which has that title.
     * @return Returns the book with the given title.
     * @throws BookNotFoundException If there isn't a book with the title throw the exception to be dealt with later.
     */

    public Book getBook(String title) throws BookNotFoundException{

        title = "\"" + title + "\"";

        for(Book book : bookInventory){//for each book in book inventory

            if(book.getTitle().equals(title)){//check if we have a title match

                return book;//if we do return that book with the match

            }

        }

        throw new BookNotFoundException();//if it reaches here there are no matches so throw an exception
        //this will be dealt with later

    }

    /**
     * Works out the total value of the whole inventory.
     * @return Returns total inventory value.
     */

    public double totalInventoryValue(){

        double totalInvValue = 0;

        for(Book book : bookInventory){//for each book in book

            totalInvValue = totalInvValue + book.getCurrentStockValue();//add its current stock value to total inv value

        }

        return totalInvValue;//return total value

    }

    /**
     * Sorts the inventory into chronological order and then prints it.
     */

    public void printChronoOrder(){

        Collections.sort(bookInventory);
        System.out.println(this);

    }

    /**
     * Sorts the inventory by pages and then prints it.
     */

    public void printPagesOrder(){

        bookInventory.sort(pagesComparator);
        System.out.println(this);

    }

    /**
     * Sorts the inventory by price and then prints it.
     */

    public void printPriceOrder(){

        bookInventory.sort(priceComparator);
        System.out.println(this);

    }

    /**
     * Comparator for comparing the books in the list by pages, highest first.
     */

    private Comparator<Book> pagesComparator = (b1, b2) -> b2.getPages() - b1.getPages();

    /**
     * Comparator for comparing the books in the list by price, highest first.
     */

    private Comparator<Book> priceComparator = (b1, b2) -> (int)(b2.getPrice() - b1.getPrice());

    /**
     * Returns all books on their own line.
     * @return Returns a string with all books as strings on their own lines.
     */

    @Override
    public String toString(){

        String finalString = "";

        for(Book book : bookInventory){//for each book in the inventory

            finalString = finalString + book + "\n";//add it to the final string and move onto next line

        }

        return finalString;//return the string of all books on their own line

    }

    /* Test Harness */

    public static void main(String[] args) {

        Inventory bookInvent = new Inventory();

        bookInvent.addToInventoryFromFile("books.txt");//adds all 15 books into the inventory
        //prints a success message for each one.

        bookInvent.printChronoOrder();//sorts and then prints in chrono order, Pride and Prejudice first.

        bookInvent.printPagesOrder();//sorts and then prints in page order longest first, Ulysses first.

        bookInvent.printPriceOrder();//sorts and then prints in price order highest first,Gulliver's Travels first

        System.out.println(bookInvent.totalInventoryValue());//prints 199623.5

        try{

            System.out.println(bookInvent.getBook("Vanity Fair"));//prints out vanity fairs details
            System.out.println(bookInvent.getBook("The Bible"));//prints the exception due to the catch

        }catch(BookNotFoundException e){

            System.out.println(e);

        }

    }

}
