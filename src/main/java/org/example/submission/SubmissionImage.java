package org.example.submission;

import lombok.Data;
import org.example.Code;

import java.util.LinkedList;
import java.util.TreeMap;


@Data
public class SubmissionImage implements SubmissionFormat {

    private final String code = String.valueOf(Code.Image);
    private TreeMap<Integer, Double> models;

    public SubmissionImage(TreeMap<Integer, Double> models) {
        this.models = models;
    }
}
