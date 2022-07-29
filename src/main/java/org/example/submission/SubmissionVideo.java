package org.example.submission;

import lombok.Data;
import org.example.Code;

import java.util.LinkedList;
import java.util.TreeMap;


@Data
public class SubmissionVideo implements SubmissionFormat {

    private final String code = String.valueOf(Code.Video);

    private TreeMap<Integer, Double> models;

    public SubmissionVideo(TreeMap<Integer, Double> models) {
        this.models = models;
    }

}
