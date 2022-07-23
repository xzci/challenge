import java.util.TreeMap;
/***
 * save the Audio data
 * @author zhicheng xie
 * @version 0.01
 */
public class PostAudio extends PostData{
    PostAudio(TreeMap<Integer, Double> models) {
        super(models);
        this.setCode("Audio");
    }
    PostAudio() {
        this.setCode("Audio");
    }
}
