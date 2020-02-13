package mediabiblioteket;

import org.junit.jupiter.api.Test;
import collections.ArrayList;
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
        mediaBookTest = new Book("Book", "Book Title", "Test ID Book", 2005, "Author");
        mediaDvdTest = new DVD("DVD", "DVD Title", "Test ID DVD", 2005,  actors);
    }

    @Test
    void getMediaType() {
        assertEquals("Book",mediaBookTest.getMediaType());
        assertNotEquals("Book", mediaDvdTest.getMediaType());
    }

    @Test
    void setMediaType() {
        mediaBookTest.setMediaType("New Book");
        assertNotEquals("Book",mediaBookTest.getMediaType());
    }

    @Test
    void setMediaTypeInvalidTypeInputAndNull() {

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
        assertEquals("Test ID Book", mediaBookTest.getObjectID());
        assertNotEquals("Test ID Book", mediaDvdTest.getObjectID());
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

    }

    @Test
    void isBorrowed() {
    }

    @Test
    void setBorrowed() {
    }

    @Test
    void listInfo() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void equals() {
    }
}