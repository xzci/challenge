import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestForInput {

    @Test
    void testInput() {
        String testMsg = null;
        GetInput getInput = new GetInput();
        try {
            getInput.readDataFromFile();
        } catch (Exception e) {
            testMsg = e.toString();
        }

        assertEquals("java.lang.Exception: Submission file read failed", testMsg);
    }


    @Test
    void testInput_1() {
        String testMsg = null;
        GetInput getInput = new GetInput("/Test/Submission.txt",
                 "/Test/Input.txt");
        try {
            getInput.readDataFromFile();
        } catch (Exception e) {
            testMsg = e.toString();
        }

        assertEquals(null, testMsg);
    }
    @Test
    void testInputData() {
        String testMsg = null;
        GetInput getInput = new GetInput("/Test/Submission.txt",
                "/Test/Input.txt");
        try {
            getInput.readDataFromFile();
        } catch (Exception e) {
            testMsg = e.toString();
        }
        PostAudio postAudio = getInput.getPostAudio();
        TreeMap<Integer, Double> models = postAudio.getModels();

        assertEquals(null, testMsg);
    }

    @Test
    void testInputData_1() {
        String testMsg = null;
        GetInput getInput = new GetInput("/Test/Submission.txt",
                "/Test/Input.txt");
        try {
            getInput.readDataFromFile();
        } catch (Exception e) {
            testMsg = e.toString();
        }
        PostAudio postAudio = getInput.getPostAudio();
        LinkedList<Integer> targets = postAudio.getTargets();

        for(var i : targets)
            System.out.println(i);

        assertEquals(15, targets.get(0));
    }
}
