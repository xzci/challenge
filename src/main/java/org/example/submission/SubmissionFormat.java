package org.example.submission;

import java.util.LinkedList;
import java.util.TreeMap;

public interface SubmissionFormat {

    TreeMap<Integer, Double> getModels();

    String getCode();
}
