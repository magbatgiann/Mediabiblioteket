package mediabiblioteket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book mediaBookTest;

    @BeforeEach
    void setUp() {
        mediaBookTest = new Book("Book", "Book Title", "427769", 2005, "Author");
    }

    @Test
    void GetAuthor_JA() {
        assertEquals("Author", mediaBookTest.getAuthor());
    }

    @Test
    void SetAuthor() {
        mediaBookTest.setAuthor("New Author");
        assertEquals("New Author", mediaBookTest.getAuthor());
    }

    @Test
    void SetAuthorInvalidInput(){
        mediaBookTest.setAuthor("");
        assertNotEquals("Author", mediaBookTest.getAuthor());
        mediaBookTest.setAuthor("123");
        assertNotEquals("Author", mediaBookTest.getAuthor());
        mediaBookTest.setAuthor(null);
        assertNotEquals("Author", mediaBookTest.getAuthor());
        mediaBookTest.setAuthor("#%&/*");
        assertNotEquals("Author", mediaBookTest.getAuthor());
    }

    @Test
    void ToString() {
        Assertions.assertEquals("Book - Free\n" +
                " - Book Title - 2005 - Author", mediaBookTest.toString());
        mediaBookTest.setBorrowed(true);
        Assertions.assertEquals("Book - Borrowed\n" +
                " - Book Title - 2005 - Author", mediaBookTest.toString());
    }

    @Test
    void ListInfo() {
        Assertions.assertEquals("Title: Book Title \n" +
                "Year: 2005\n" +
                "Author: Author\n" +
                "Type: Book\n" +
                "Free\n" +
                "ID: 427769\n", mediaBookTest.listInfo());

        mediaBookTest.setBorrowed(true);
        mediaBookTest.setThisMediaBorrower(new Borrower("Borrower","700311-8888", "040-2833652"));
        Assertions.assertEquals("Title: Book Title \n" +
                "Year: 2005\n" +
                "Author: Author\n" +
                "Type: Book\n" +
                "Taken\n" +
                "Borrower: Borrower\n" +
                "ID: 427769\n", mediaBookTest.listInfo());

    }

}