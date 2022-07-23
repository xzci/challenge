import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class GetInput {

    private String filePathBundles = System.getProperty("user.dir");
    private String filePathTarget = System.getProperty("user.dir");
    private PostAudio postAudio = new PostAudio();
    private PostVideo postVideo = new PostVideo();
    private PostImage postImage = new PostImage();
    Logger logger = Logger.getGlobal();


    GetInput() {

    }

    GetInput(String filePathBundles, String filePathTarget) {
        this.filePathBundles = this.filePathTarget + filePathBundles;
        this.filePathTarget =  this.filePathTarget + filePathTarget;
    }


    public void setFilePathBundles(String filePathBundles) {
        this.filePathBundles = this.filePathTarget + filePathBundles;
    }

    public void setFilePathTarget(String filePathTarget) {
        this.filePathTarget =  this.filePathTarget + filePathTarget;
    }

    public void readDataFromFile() throws Exception {
        if(filePathBundles.isBlank() || filePathBundles.isEmpty())
            throw new FileNotFoundException("Submission file is not found");

        if(filePathTarget.isBlank() || filePathTarget.isEmpty())
            throw new FileNotFoundException("Input file is not found");

        try {
            readSubmissionFile();
        } catch (Exception e) {
            logger.warning("Submission file read failed");
            throw new Exception("Submission file read failed");
        }

        try {
            readInputFile();
        } catch (Exception e) {
            logger.warning("Input file read failed");
            throw new Exception("Input file read failed");
        }
    }
    private void readSubmissionFile() throws Exception {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePathBundles));

            String line = "";
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while(line != null) {
                classifyBundlesData(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    private void readInputFile() throws Exception {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePathTarget));

            String line = "";
            line = bufferedReader.readLine();

            while(line != null) {
                classifyTargetData(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }


    public void readDataFromConsole() {
        //TODO
    }
    private void classifyBundlesData(String data) throws InputMismatchException {
        String code = getCodeFromBundle(data);
        try {
            switch (code) {
                case "Image":
                    postImage.setModels(getModelsFromString(data));
                    break;
                case "Audio":
                    postAudio.setModels(getModelsFromString(data));
                    break;
                case "Video":
                    postVideo.setModels(getModelsFromString(data));
                    break;
                default:

                    throw new InputMismatchException();
            }
        } catch (Exception e) {
            logger.warning("Un support content or format of submission file ");
            throw new InputMismatchException();
        }
    }

    private void classifyTargetData(String data) throws InputMismatchException {
        String[] dataSplite = data.split(" ");
        try {
        switch (dataSplite[1]) {
            case "IMG":
                postImage.addTarget(Integer.parseInt(dataSplite[0]));
                break;
            case "FLAC":
                postAudio.addTarget(Integer.parseInt(dataSplite[0]));
                break;
            case "VID":
                postVideo.addTarget(Integer.parseInt(dataSplite[0]));
                break;
            default:
                throw new InputMismatchException();
            }
        }
        catch(Exception e) {
            logger.warning("Un support content or format of Input file");
            throw new InputMismatchException();
        }

    }
    private String getCodeFromBundle(String data) {

            if (data.substring(0, 5).equals("Image"))
                return "Image";
            else if (data.substring(0, 5).equals("Audio"))
                return "Audio";
            else if (data.substring(0, 5).equals("Video"))
                return "Video";
            else
                return "";
    }

    private TreeMap<Integer, Double> getModelsFromString(String data) throws Exception {
        TreeMap<Integer, Double> models = new TreeMap<>();
        int key = 0;
        double value = 0;

        String[] dataSplits = data.split("\\|");

        String[] dataSplitsEnd = dataSplits[2].split(" ");

        for(int i = 0; i < dataSplitsEnd.length - 3; i+= 3) {
            try {

                key = Integer.parseInt(dataSplitsEnd[i + 1]);
            }
            catch (Exception e) {
                logger.warning("key cannot be recognized");
                throw new Exception();
            }

            try {
                value = Double.parseDouble(dataSplitsEnd[i + 3].substring(1));
            }
            catch (Exception e) {
                logger.warning("value cannot be recognized");
                throw new Exception();
            }
            models.put(key, value);
        }
        return models;
    }

    public PostAudio getPostAudio() {
        return postAudio;
    }

    public PostImage getPostImage() {
        return postImage;
    }

    public PostVideo getPostVideo() {
        return postVideo;
    }

    public String getFilePathBundles() {
        return filePathBundles;
    }

    public String getFilePathTarget() {
        return filePathTarget;
    }
}
