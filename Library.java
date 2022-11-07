import java.util.Hashtable;

/** Library child class of Building with collection of books and methods to modify it*/
public class Library extends Building {

  private Hashtable<String, Boolean> collection;

    /**
     * Constructor constructs a Building with the given parameters, then initializes the collection of books
     * @param name
     * @param address
     * @param floors
     */
    public Library(String name, String address, int floors) {
      super(name, address, floors);
      collection = new Hashtable<String, Boolean>();

      System.out.println("You have built a Library!");
    }

    /**
     * Adds a book title to the collection
     * @param title
     */
    public void addTitle(String title) {
      collection.put(title, true);
    }

    /**
     * Removes a book title from the collection
     * @param title
     * @return title
     */
    public String removeTitle(String title){
      collection.remove(title);
      return title;
    } 

    /**
     * Checks out a book from the collection
     * @param title
     */
    public void checkOut(String title) {
      collection.replace(title, false);
    }

    /**
     * Returns a book to the collection
     * @param title
     */
    public void returnBook(String title) {
      collection.replace(title, true);

    }

    /**
     * Checks if a given title is in the collection
     * @param title
     * @return collection.containsKey(title)
     */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

    /**
     * Checks if a given title is available
     * @param title
     * @return collection.get(title)
     */
    public boolean isAvailable(String title) {
      return collection.get(title);
    }

    /**
     * Prints the collection of books
     */
    public void printCollection() {
      System.out.println(collection);
    }
  
    public static void main(String[] args) {
      Library myLibrary = new Library("myLibrary", "42 Gilford Street", 2);
      myLibrary.addTitle("The Lorax by Dr. Seuss");
      myLibrary.addTitle("Harry Potter and the Chamber of Secrets by JK Rowling");
      myLibrary.printCollection();
      myLibrary.checkOut("The Lorax by Dr. Seuss");
      System.out.println(myLibrary.isAvailable("The Lorax by Dr. Seuss"));

      myLibrary.returnBook("The Lorax by Dr. Seuss");
      myLibrary.printCollection();
      System.out.println(myLibrary.isAvailable("The Lorax by Dr. Seuss"));

    }
  
  }