package org.example.submission;

import lombok.Data;
import org.example.Code;

import java.util.TreeMap;


@Data
public class SubmissionAudio implements SubmissionFormat {

    private final String code = String.valueOf(Code.Audio);

    private TreeMap<Integer, Double> models;

    public SubmissionAudio(TreeMap<Integer, Double> models) {
        this.models = models;
    }

}
