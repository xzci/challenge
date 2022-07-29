package org.example.order;

import org.example.submission.SubmissionAudio;
import org.example.submission.SubmissionFormat;
import org.example.submission.SubmissionImage;
import org.example.submission.SubmissionVideo;

import java.util.InputMismatchException;

public class OrderFactory {

    public Order getOrder(String data) throws InputMismatchException{
        String[] dataSplite = data.split(" ");
        String code = dataSplite[1];

        switch (code) {
            case "IMG":
                return new OrderImage(Integer.parseInt(dataSplite[0]));
            case "FLAC":
                return new OrderAudio(Integer.parseInt(dataSplite[0]));
            case "VID":
                return new OrderVideo(Integer.parseInt(dataSplite[0]));
            default:
                return null;
        }
    }
}
