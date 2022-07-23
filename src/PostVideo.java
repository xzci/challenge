import java.util.Map;
import java.util.TreeMap;
/***
 * save the video data
 * @author zhicheng xie
 * @version 0.01
 */
public class PostVideo extends PostData {
    PostVideo(TreeMap<Integer, Double> models) {
        super(models);
        this.setCode("Video");
    }
    PostVideo() {
        this.setCode("Video");
    }
}
