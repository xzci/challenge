import java.util.*;
/***
 * Calculate the bundles
 * @author zhicheng xie
 * @version 0.01
 */
public class Algorithm {
    /***
     *
     * @param :
     * TreeMap<Integer, Double> models,  save the submission mode, key is the Bundles value is the price
     * Integer target, the amount of customer want to buy
     * String simpleMode  keep the code and still use the same name.
     */
    public String calculateWithOutput(TreeMap<Integer, Double> models, Integer target, String simpleMode) {
        if(models.containsKey(target)) {
            return "1 x " +  target + " $" + models.get(target) * target;
        } else if(target > models.lastKey()) {
            String ans = new String();
            int temp = target;

            int nums = target / models.lastKey();
            if (target % models.lastKey() == 0) {
                return nums + " x " +  target + " $" + models.get(target) * target;
            }
            else {
                if (models.containsKey(target % models.lastKey())) {
                    return nums + " x " +  target + " $" + models.get(models.lastKey()) * target +
                            1 + " x " +  target % models.lastKey() + " $" +
                            models.get(target % models.lastKey()) * target % models.lastKey();
                } else {
                    return (nums + 1) + " x " +  models.lastKey().toString() + " $" + (models.get(models.lastKey()) * target);
                }
            }

        } else {
            int larger = models.firstKey();
            for (var i: models.keySet()) {
                if(i > target) {
                    larger = i;
                    break;
                }
            }
            return "1 x " +  larger + " $" + models.get(larger) * larger;
        }

    }


    /***
     * 'Knapsack problem'
     * the output part is ugly but easy to finish, it can easily rewrite as the a new method, or overwrite the toString.
     * @param :
     * TreeMap<Integer, Double> models,  save the submission mode, key is the Bundles value is the price
     * Integer target, the amount of customer want to buy
     */
    public String calculateWithOutput(TreeMap<Integer, Double> models, Integer target) {
        int[] path = new int[models.size()];
        LinkedList<Integer> result;
        String ans = new String();
        double amount = 0.0;
        int j = 0;
        for (var i : models.keySet()) {
            path[j++] = i;
        }
        result = algorithm(path, target);

        Integer frontNode = result.get(0);
        int count = 0;
        for(int i = 1; i < result.size(); i++) {
            if(frontNode.equals(result.get(i)))
                count++;
            else {
                ans += (count + 1) + " x " +  result.get(i - 1) +
                        " $" + (models.get(result.get(i- 1)) * (count + 1)) + "\n";
                amount += (models.get(result.get(i - 1)) * (count + 1));
                count = 0;
                frontNode = result.get(i);
            }
        }
        ans += (count + 1) + " x " + result.getLast()+
                " $" + (models.get(result.getLast()) * (count + 1)) + "\n";
        amount +=  (models.get(result.getLast()) * (count + 1));
        return "$" + amount + "\n" + ans.trim();

    }
    /***
     * 'Knapsack problem'
     *
     * @param :
     * int[] bundles,  save the submission mode, in this part only bundles are considered.
     * int amount, the amount of customer want to buy
     */
    private LinkedList<Integer> algorithm (int[] bundles, int amount) {
        int max = amount + 1;

        int[] dp = new int[amount + 1];
        ArrayList<LinkedList<Integer>> path = new ArrayList<>();
        for(int i = 0; i < amount + 1; i++)
            path.add(new LinkedList<>());

        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int temp = dp[i];
            for (int j = 0; j < bundles.length; j++) {
                if (bundles[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - bundles[j]] + 1);
                    if(dp[i] != temp) {
                        if(dp[i - bundles[j]] < dp[i]) {
                            path.get(i).clear();
                            for (var node : path.get(i - bundles[j])) {
                                path.get(i).add(node);
                            }
                            path.get(i).add(bundles[j]);
                        }
                    }
                }
            }
        }
        return path.get(path.size() - 1);
    }

}
