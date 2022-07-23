import java.util.Map;
import java.util.TreeMap;

public class PostVideo extends PostData {
    PostVideo(TreeMap<Integer, Double> models) {
        super(models);
        this.setCode("Video");
    }
    PostVideo() {
        this.setCode("Video");
    }
}
