package mediabiblioteket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;



class MediaTest {

    private Media mediaBookTest;
    private Media mediaDvdTest;
    private LinkedList<String>actors;

    @BeforeEach
    void setUp() {
        actors = new LinkedList<>();
        actors.add("Actor 1");
        actors.add("Actor 2");
        mediaBookTest = new Book("Book", "Book Title", "123456", 2005, "Author");
        mediaDvdTest = new DVD("DVD", "DVD Title", "654321", 2005,  actors);
    }

    @Test
    void getMediaType_GE() {
        assertEquals("Book",mediaBookTest.getMediaType());
        assertNotEquals("Book", mediaDvdTest.getMediaType());
    }

    @Test
    void setMediaType_GE() {
        mediaBookTest.setMediaType("New Book");
        assertNotEquals("Book",mediaBookTest.getMediaType());
    }

    @Test
    void setMediaTypeInvalidTypeInputAndNull_GE() {

        mediaBookTest.setMediaType("");
        assertNotEquals("New Book", mediaBookTest.getMediaType());
        mediaBookTest.setMediaType("11111");
        assertNotEquals("New Book", mediaBookTest.getMediaType());
        mediaBookTest.setMediaType(null);
        assertNotEquals("New Book", mediaBookTest.getMediaType());
        mediaBookTest.setMediaType("+-*/&%¤#!");
        assertNotEquals("New Book", mediaBookTest.getMediaType());
        mediaDvdTest.setMediaType("");
        assertNotEquals("New Dvd", mediaDvdTest.getMediaType());
        mediaDvdTest.setMediaType("11111");
        assertNotEquals("New Dvd", mediaDvdTest.getMediaType());
        mediaDvdTest.setMediaType(null);
        assertNotEquals("New Dvd", mediaDvdTest.getMediaType());
        mediaDvdTest.setMediaType("+-*/&%¤#!");
        assertNotEquals("New Dvd", mediaDvdTest.getMediaType());
    }
    @Test
    void getTitle() {
        assertEquals("Book Title", mediaBookTest.getTitle());
        assertNotEquals("book Title", mediaDvdTest.getTitle());
    }

    @Test
    void setTitle() {
        mediaBookTest.setTitle("New Title");
        assertEquals("New Title",mediaBookTest.getTitle());
    }

    @Test
    void setMediaTitleTypeInvalidInputAndNull() {

        mediaBookTest.setTitle("");
        assertNotEquals("Book", mediaBookTest.getTitle());
        mediaDvdTest.setTitle("");
        assertNotEquals("Dvd", mediaDvdTest.getTitle());
        mediaBookTest.setTitle("11111");
        assertNotEquals("Book", mediaBookTest.getTitle());
        mediaDvdTest.setTitle("11111");
        assertNotEquals("Dvd", mediaDvdTest.getTitle());
        mediaBookTest.setTitle(null);
        assertNotEquals("Book", mediaBookTest.getTitle());
        mediaDvdTest.setTitle(null);
        assertNotEquals("Dvd", mediaDvdTest.getTitle());
        mediaBookTest.setTitle("%!&%+-/");
        assertNotEquals("Book", mediaBookTest.getTitle());
        mediaDvdTest.setTitle("+*/*-");
        assertNotEquals("Dvd",mediaDvdTest.getTitle());
    }
    @Test
    void getObjectID() {
        assertEquals("123456", mediaBookTest.getObjectID());
        assertEquals("654321", mediaDvdTest.getObjectID());
    }

    @Test
    void setObjectID() {
        mediaBookTest.setObjectID("New ID Book");
        assertEquals("New ID Book",mediaBookTest.getObjectID());
    }

    @Test
    void getYear() {
        assertEquals(2005 , mediaBookTest.getYear());
        assertNotEquals("1996", mediaDvdTest.getYear());
    }

    @Test
    void setYear() {
        mediaBookTest.setYear(2020);
        assertEquals(2020,mediaBookTest.getYear());
    }

    @Test
    void getThisMediaBorrower() {
        mediaBookTest.getThisMediaBorrower();
        assertEquals(700311-8888,691423);

    }

    @Test
    void setThisMediaBorrower() {
        Borrower borrower = new Borrower("","","");
        mediaBookTest.setThisMediaBorrower(borrower);
        assertEquals(borrower, mediaBookTest.getThisMediaBorrower());

    }

    @Test
    void isBorrowed() {
        mediaBookTest.setBorrowed(true);
        assertTrue(mediaBookTest.isBorrowed());
    }

    @Test
    void setBorrowed() {
        mediaBookTest.setBorrowed(false);
        assertFalse(mediaBookTest.isBorrowed());
        assertFalse(mediaDvdTest.isBorrowed());
    }

    @Test
    void compareTo() {
        Media mediaToCompare = new Book("Book", "Book Title", "123456", 2005, "Author");
        assertEquals(0, mediaToCompare.compareTo(mediaBookTest));
        mediaToCompare.setObjectID("1");
        assertTrue(mediaToCompare.compareTo(mediaBookTest)<0);
        mediaToCompare.setObjectID("11111");
        assertFalse(mediaToCompare.compareTo(mediaBookTest)>0);
        Borrower borrower = new Borrower("","","");
        assertTrue(mediaToCompare.compareTo(borrower)<0);
    }

    @Test
    void ListInfo() {
        Assertions.assertEquals("Title: Book Title \n" +
                "Year: 2005\n" +
                "Author: Author\n" +
                "Type: Book\n" +
                "Free\n" +
                "ID: 123456\n", mediaBookTest.listInfo());

        mediaBookTest.setBorrowed(true);
        mediaBookTest.setThisMediaBorrower(new Borrower("Borrower","700311-8888", "040-2833652"));
        Assertions.assertEquals("Title: Book Title \n" +
                "Year: 2005\n" +
                "Author: Author\n" +
                "Type: Book\n" +
                "Taken\n" +
                "Borrower: Borrower\n" +
                "ID: 123456\n", mediaBookTest.listInfo());

    }

    @Test
    void equals() {
        Media media = mediaBookTest;
        Borrower borrower = new Borrower("","","");
        assertTrue(mediaBookTest.equals(media));
        assertFalse(mediaBookTest.equals(mediaDvdTest));
        assertFalse(mediaBookTest.equals(borrower));
    }
}