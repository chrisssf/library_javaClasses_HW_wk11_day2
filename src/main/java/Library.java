import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private int capacity;

    public Library(ArrayList<Book> books, int capacity){
        this.books = books;
        this.capacity = capacity;
    }

    public int bookCount() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if ( this.capacity > this.books.size() ) {
            this.books.add(book);
        }
    }

    public boolean giveBook(Book book) {
        if ( this.books.contains(book)){
            this.books.remove(book);
            return true;
        }
        return false;
    }
}
