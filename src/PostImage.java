import java.util.Map;
import java.util.TreeMap;
/***
 * save the Image data
 * @author zhicheng xie
 * @version 0.01
 */
public class PostImage extends PostData {

    PostImage(TreeMap<Integer, Double> models) {
        super(models);
        this.setCode("Image");
    }

    PostImage() {
        this.setCode("Image");
    }
}
