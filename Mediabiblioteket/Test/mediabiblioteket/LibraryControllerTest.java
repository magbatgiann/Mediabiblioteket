package mediabiblioteket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {
LibraryController controller = new LibraryController();

    @Test
    void checkUserInput() {
        boolean test = controller.checkUserInput("dvd");
        assertEquals(true,test);
    }
    @Test
    void checkUserInputFalse() {
        boolean test = controller.checkUserInput("!#%");
        assertEquals(false,test);
    }

    @Test
    void checkInputOnlyDigits() {
        boolean test = controller.checkInputOnlyDigits("700311888");
        assertEquals(true,test);

    }

    @Test
    void checkInputOnlyDigitsFalse() {
        boolean test = controller.checkInputOnlyDigits("%&/");
        assertEquals(false,test);

    }
    @Test
    void writeToFile() {
    }

    @Test
    void borrowMedia() {
    }

    @Test
    void returnMedia() {
    }

    @Test
    void checkIfBorrowerExist() {
    }

    @Test
    void sortMedia() {
    }

    @Test
    void getMedia() {
    }

    @Test
    void showSelectedMediaInfo() {
    }

    @Test
    void searchMediaAllByString() {
    }

    @Test
    void getMediaFromSearchResult() {
    }

    @Test
    void searchMediaTitleByString() {
    }

    @Test
    void getBorrower() {
    }

    @Test
    void loadBorrowedMedia() {
    }

    @Test
    void searchBorrowed() {
    }
}