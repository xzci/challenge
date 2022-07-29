package org.example.submission;

import lombok.Data;

import java.util.TreeMap;

@Data
public class SubmissionFactory {

    public SubmissionFormat getSubmissionFormat(String data) {
        String code = getCode(data);
        try {
            switch (code) {
                case "Image":
                    return new SubmissionImage(getModels(data));
                case "Audio":
                    return new SubmissionAudio(getModels(data));
                case "Video":
                    return new SubmissionVideo(getModels(data));
                default:
                    return null;
            }
        } catch (Exception e) {

        }
        return null;
    }


    private String getCode(String data) {

        if (data.substring(0, 5).equals("Image"))
            return "Image";
        else if (data.substring(0, 5).equals("Audio"))
            return "Audio";
        else if (data.substring(0, 5).equals("Video"))
            return "Video";
        else
            return "";
    }

    private TreeMap<Integer, Double> getModels(String data) throws Exception {
        TreeMap<Integer, Double> models = new TreeMap<>();
        int key = 0;
        double value = 0;

        String[] dataSplits = data.split("\\|");

        String[] dataSplitsEnd = dataSplits[2].split(" ");

        for (int i = 0; i < dataSplitsEnd.length - 3; i += 3) {
            try {

                key = Integer.parseInt(dataSplitsEnd[i + 1]);
            } catch (Exception e) {
                throw new Exception();
            }

            try {
                value = Double.parseDouble(dataSplitsEnd[i + 3].substring(1));
            } catch (Exception e) {
                throw new Exception();
            }
            models.put(key, value);
        }
        return models;
    }
}
