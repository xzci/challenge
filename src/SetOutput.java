import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
/***
 * save the output data
 * @author zhicheng xie
 * @version 0.01
 */
public class SetOutput {
    private String saveFileName;
    private StringBuilder content;
    Logger logger = Logger.getGlobal();
    SetOutput() {
    }

    SetOutput(String saveFilePath) {

        this.saveFileName = saveFilePath;
    }

    public void setSaveFileName(String saveFilePath) {
        this.saveFileName = saveFilePath;
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }


    public void save() throws IOException {
        try {
            FileWriter writer = new FileWriter(saveFileName);
            writer.write(String.valueOf(this.content));
            writer.flush();
            writer.close();
        }
        catch(IOException e) {
            throw new IOException();
        }
    }

}
