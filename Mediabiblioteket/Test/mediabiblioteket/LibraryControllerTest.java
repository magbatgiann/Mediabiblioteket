package mediabiblioteket;

import org.junit.jupiter.api.Test;
import collections.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {
LibraryController controller = new LibraryController();
    JFrame frame = new JFrame();


    @Test
    void checkUserInputWithoutInput() {
        boolean test = controller.checkUserInput("");
        assertEquals(false,test);

    }
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
    void checkUserInputNull() {
        assertFalse(controller.checkUserInput(null));
    }

    @Test
    void checkInputOnlyDigits() {
        boolean test = controller.checkInputOnlyDigits("635492");
        assertEquals(true,test);

    }

    @Test
    void checkInputOnlyDigitsFalse() {
        boolean test = controller.checkInputOnlyDigits("*/-");
        assertEquals(false,test);

    }

    @Test
    void checkInputOnlyDigitsNull() {
        assertFalse(controller.checkInputOnlyDigits(null));
    }
    @Test
    void checkInputOnlyDigitsWithoutInput() {
        boolean test = controller.checkInputOnlyDigits("");
        assertEquals(false,test);

    }
    @Test
    void writeToFile() {
        String testdata = "111111-1111;111111";
        controller.borrowed.add(testdata);
        controller.writeToFile();
        String theLine = "";
        try {
            Scanner theScanner = new Scanner(new File("Mediabiblioteket/files/Utlanade.txt"));
            while (theScanner.hasNext()){
                theLine = theScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(testdata, theLine);
        controller.borrowed.removeLast();
        controller.writeToFile();
    }

    @Test
    void borrowMedia() {
        Book testbook = new Book("Book","Ondskans leende", "993782", 2006, "Fredriksson");
        Borrower testBorrower= new Borrower("Pernilla Johansson", "700311-8888", "040-2833652");
        controller.setCurrentBorrower(testBorrower);
        controller.borrowMedia(testbook);
        assertTrue(testbook.borrowed);
    }

    @Test
    void returnMedia() {
        Book testbook = new Book("Book","Ondskans leende", "993782", 2006, "Fredriksson");
        Borrower testBorrower= new Borrower("Pernilla Johansson", "700311-8888", "040-2833652");
        controller.setCurrentBorrower(testBorrower);
        controller.borrowMedia(testbook);
        controller.returnMedia(testbook);
        assertFalse(testbook.borrowed);
    }

    @Test
    void checkIfBorrowerExist() {
        String userID1 = "121212-1212";
        String userID2 = "700311-8888";
        Boolean borrowerResult1 = controller.checkIfBorrowerExist(userID1);
        Boolean borrowerResult2 = controller.checkIfBorrowerExist(userID2);
        assertFalse(borrowerResult1);
        assertTrue(borrowerResult2);
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