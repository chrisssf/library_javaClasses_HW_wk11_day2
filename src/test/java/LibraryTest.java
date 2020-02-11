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
    private Borrower borrower;

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
        borrower = new Borrower();
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

    @Test
    public void canBorrowABook(){
//        library.giveBook(book1);
        assertEquals(3, library.bookCount());
        assertEquals(0, borrower.getBorrowedBooks());
        borrower.borrowBook(book1, library);
        assertEquals(2, library.bookCount());
        assertEquals(1, borrower.getBorrowedBooks());
    }

    @Test
    public void cantBorrowBookIfNotInLibrary(){
        borrower.borrowBook(book4, library);
        assertEquals(3, library.bookCount());
        assertEquals(0, borrower.getBorrowedBooks());
    }
}
