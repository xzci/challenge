import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class PostData {
    private String code = "Data";
    private TreeMap<Integer, Double> models;
    private LinkedList<Integer> targets = new LinkedList<>();

    private Integer amount = 0;

    PostData() {

    }
    PostData(TreeMap<Integer, Double> models) {
        this.models = models;
    }

    public void setModels(TreeMap<Integer, Double> models) {
        this.models = models;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addTarget(Integer target) {
        this.targets.add(target);
        this.amount += target;
    }

    public void addTargets(LinkedList<Integer> targets) {
        for (var target: targets) {
            this.targets.add(target);
            this.amount += target;
        }
    }
    public String getCode() {
        return code;
    }

    public TreeMap<Integer, Double> getModels() {
        return models;
    }

    public LinkedList<Integer> getTargets() {
        return targets;
    }

    public Integer getAmount() {
        return amount;
    }
}
