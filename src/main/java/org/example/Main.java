package org.example;

import org.example.fileInputOutput.FileInputOutput;
import org.example.order.Order;
import org.example.order.OrderFactory;
import org.example.calculation.Calculation;
import org.example.submission.SubmissionFactory;
import org.example.submission.SubmissionFormat;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputOutput io = new FileInputOutput();
        io.setSubmissionFilePath(System.getProperty("user.dir") + "/src/test/resources/Submission.txt");
        io.setOrderFilePath(System.getProperty("user.dir") + "/src/test/resources/Input.txt");
        io.setOutputFilePath(System.getProperty("user.dir") + "/src/test/resources/output");
        SubmissionFactory submissionFactory = new SubmissionFactory();

        OrderFactory orderFactory = new OrderFactory();
        LinkedList<Order> orders = new LinkedList<>();
        LinkedList<SubmissionFormat> submissionFormats = new LinkedList<>();
        Calculation calculation = new Calculation();
        for (var i : io.readOrder()) {
            orders.add(orderFactory.getOrder(i));
        }

        for (var i : io.readSubmission()) {
            submissionFormats.add(submissionFactory.getSubmissionFormat(i));
        }
        String ans = new String();

        // this part might use stream, I am still leaning
//        for (var order : orders)
//            for (var submission : submissionFormats) {
//                if (order.getCode().equals(submission.getCode())) {
//                    calculation.setOrder(order);
//                    calculation.setSubmissionFormat(submission);
//                    calculation.calculate();
//                    ans += calculation.toString();
//                    break;
//                }
//            }

        for (var myorder : orders) {
            calculation.setOrder(myorder);
            calculation.setSubmissionFormat(submissionFormats.stream().filter(submission ->
                    submission.getCode().equals(myorder.getCode())).findFirst().orElseThrow());
            calculation.calculate();
            ans += calculation.toString();
        }
        io.setContent(ans);
        io.save();
    }
}