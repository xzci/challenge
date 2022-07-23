
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    /***
     * There are still lots of points are unclear. However, I worte this code in the midnight, I have no chance to ask,
     * I made such assumption to finish this project:
     * this project requires to have minimal number of bundles. however, in the test case3:
     * The output is:
     * 13 VID $2370
     *   2 x 5 $1800
     *   1 x 3 $570
     * not 2 X 9, which means it need to consider the optimization, make that do not have much waste.
     *
     * which make it become a 'Knapsack problem'.
     *
     *  Total hours: 6 hours
     *  Limitation: I should use csv at first, the string split method is ugly, and I do not know if i should make it
     *  more complex, for example, overwrite the tostring method and provide an interface.
     *  and I also forget how to use log, I forget how to test them.:<
     * @author zhicheng xie
     * @version 0.01
     */
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        Logger logger = Logger.getGlobal();
        logger.info("operating beginning");
        GetInput getInput = new GetInput("/Test/Submission.txt",
                "/Test/Input.txt");
        try {
            getInput.readDataFromFile();
        } catch (Exception e)
        {
            logger.warning("Read file failed");

        }

        SetOutput setOutput = new SetOutput();
            StringBuilder ans = new StringBuilder();

        setOutput.setSaveFileName("results.txt");

        ans.append(getInput.getPostAudio().getAmount() + " " + getInput.getPostAudio().getCode() + " ");
        for(var target : getInput.getPostAudio().getTargets()) {
           ans.append(algorithm.calculateWithOutput(getInput.getPostAudio().getModels(), target));
        }
        ans.append("\n");

        ans.append(getInput.getPostImage().getAmount() + " " + getInput.getPostImage().getCode() + " ");
        for(var target : getInput.getPostImage().getTargets()) {
            ans.append(algorithm.calculateWithOutput(getInput.getPostImage().getModels(), target));
        }
        ans.append("\n");

        ans.append(getInput.getPostVideo().getAmount() + " " + getInput.getPostVideo().getCode() + " ");
        for(var target : getInput.getPostVideo().getTargets()) {
            ans.append(algorithm.calculateWithOutput(getInput.getPostVideo().getModels(), target));
        }

        setOutput.setContent(ans);

        try {
            setOutput.save();
        } catch (IOException e) {
            logger.warning("Writing file failed");
            throw new RuntimeException(e);
        }

        logger.info("operating end");
    }
}