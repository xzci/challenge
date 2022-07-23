import java.util.Map;
import java.util.TreeMap;

public class PostImage extends PostData {

    PostImage(TreeMap<Integer, Double> models) {
        super(models);
        this.setCode("Image");
    }

    PostImage() {
        this.setCode("Image");
    }
}
