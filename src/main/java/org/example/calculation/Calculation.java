package org.example.calculation;

import lombok.Data;
import org.example.order.Order;
import org.example.submission.SubmissionFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

@Data
public class Calculation {

    private Order order;
    private SubmissionFormat submissionFormat;

    private LinkedList<Double> postPrices = new LinkedList<>();
    private LinkedList<String> postDetails = new LinkedList<>();
    private Double postTotalPrices;

    private Integer postAmount = 0;

    public void calculate() {
        postPrices.clear();
        postDetails.clear();
        postTotalPrices = 0.0;


        int[] path = new int[submissionFormat.getModels().size()];
        int j = 0;
        for (var i : submissionFormat.getModels().keySet()) {
            path[j++] = i;
        }

        LinkedList<Integer> result;
        double totalPrice = 0.0;
        result = calculateAlgorithm(path, order.getPost());
        Integer frontNode = result.get(0);
        int count = 0;
        for (int i = 1; i < result.size(); i++) {
            if (frontNode.equals(result.get(i)))
                count++;
            else {
                this.postDetails.add((count + 1) + " x " + result.get(i - 1));
                this.postPrices.add((submissionFormat.getModels().get(result.get(i - 1)) * (count + 1)));

                totalPrice += (submissionFormat.getModels().get(result.get(i - 1)) * (count + 1));
                count = 0;
                frontNode = result.get(i);
            }
        }

        this.postDetails.add((count + 1) + " x " + result.getLast());
        this.postPrices.add((submissionFormat.getModels().get(result.getLast()) * (count + 1)));
        totalPrice += (submissionFormat.getModels().get(result.getLast()) * (count + 1));
        this.postTotalPrices = totalPrice;
    }

    private LinkedList<Integer> calculateAlgorithm(int[] bundles, int amount) {
        int max = amount + 1;

        int[] dp = new int[amount + 1];
        ArrayList<LinkedList<Integer>> path = new ArrayList<>();
        for (int i = 0; i < amount + 1; i++)
            path.add(new LinkedList<>());

        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int temp = dp[i];
            for (int j = 0; j < bundles.length; j++) {
                if (bundles[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - bundles[j]] + 1);
                    if (dp[i] != temp) {
                        if (dp[i - bundles[j]] < dp[i]) {
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

    @Override
    public String toString() {
        String result = new String();
        for (int i = 0; i < this.postDetails.size(); i++) {
            result += String.format("  %s $ %.2f \n", this.postDetails.get(i), this.postPrices.get(i));
        }
        return order.getPost() + " " + submissionFormat.getCode() +
                " " + this.postTotalPrices + "\n" + result;
    }
}


