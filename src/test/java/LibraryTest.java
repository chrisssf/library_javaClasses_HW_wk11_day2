import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Library library2;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @Before
    public void before(){
        book1 = new Book("Java for dummies", "Java McExpert", "Educational");
        book2 = new Book("Harry Potter", "JK", "Childrens");
        book3 = new Book("Sporting Miracles", "Sporty Spice", "Sport");
        ArrayList<Book> booksForLibrary = new ArrayList<Book>();
        booksForLibrary.add(book1);
        booksForLibrary.add(book2);
        booksForLibrary.add(book3);
        library = new Library(booksForLibrary, 5);
        book4 = new Book("The Hobbit", "Tolken", "Adventure");
        library2 = new Library(booksForLibrary, 3);
    }

    @Test
    public void countNumberOfBooks(){
        assertEquals(3, library.bookCount());
    }

    @Test
    public void canAddBook(){
        library.addBook(book4);
        assertEquals(4, library.bookCount());
    }

    @Test
    public void cantAddBookIfFull(){
        library2.addBook(book4);
        assertEquals(3, library2.bookCount());
    }

}
