import java.util.TreeMap;

public class PostAudio extends PostData{
    PostAudio(TreeMap<Integer, Double> models) {
        super(models);
        this.setCode("Audio");
    }
    PostAudio() {
        this.setCode("Audio");
    }
}
