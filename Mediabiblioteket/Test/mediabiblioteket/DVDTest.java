package mediabiblioteket;

import collections.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DVDTest {

    private DVD mediaDvdTest;
    private LinkedList<String> actors;

    @BeforeEach
    void setUp() {
        actors = new LinkedList<>();
        actors.add("Actor 1");
        actors.add("Actor 2");
        mediaDvdTest = new DVD("DVD", "DVD Title", "768841", 2005,  actors);
    }

    @Test
    void SetAndGetActors_JA(){
        LinkedList<String> testActors = new LinkedList<>();
        testActors.add("Actor 1");
        testActors.add("Actor 2");
        testActors.add("Actor 3");
        int actorsList = mediaDvdTest.getActors().size();
        actors.add("Actor 3");
        mediaDvdTest.setActors(actors);
        Assertions.assertEquals(actorsList+1, mediaDvdTest.getActors().size());
        boolean same = false;
        int count = 0;
        for (int i = 0; i < mediaDvdTest.getActors().size(); i++ ){
            if (testActors.get(i).equals(mediaDvdTest.getActors().get(i)))
                count++;
        }

        if (count==mediaDvdTest.getActors().size())
            same = true;

        Assertions.assertTrue(same);
    }

    @Test
    void ToString_JA(){
        Assertions.assertEquals("DVD - Free\n" +
                " - DVD Title - 2005 - Actor 1 - Actor 2", mediaDvdTest.toString());
        mediaDvdTest.setBorrowed(true);
        Assertions.assertEquals("DVD - Borrowed\n" +
                " - DVD Title - 2005 - Actor 1 - Actor 2", mediaDvdTest.toString());
    }

    @Test
    void ListInfo(){
        Assertions.assertEquals("Title: DVD Title \n" +
                "Year: 2005\n" +
                "Actors: Actor 1 - Actor 2\n" +
                "Type: DVD\n" +
                "Free\n" +
                "ID: 768841\n", mediaDvdTest.listInfo());

        mediaDvdTest.setBorrowed(true);
        mediaDvdTest.setThisMediaBorrower(new Borrower("Borrower","700311-8888", "040-2833652"));
        Assertions.assertEquals("Title: DVD Title \n" +
                "Year: 2005\n" +
                "Actors: Actor 1 - Actor 2\n" +
                "Type: DVD\n" +
                "Is Borrowed\n" +
                "Borrower: Borrower\n" +
                "ID: 768841\n", mediaDvdTest.listInfo());

    }

}