package org.example;

import lombok.Data;
import org.example.order.Order;
import org.example.submission.SubmissionFormat;

@Data
public class Pair<T, T1> {
    private Order order;
    private SubmissionFormat submissionFormat;
}
