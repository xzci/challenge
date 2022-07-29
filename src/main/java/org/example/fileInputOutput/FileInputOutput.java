package org.example.fileInputOutput;

import lombok.Data;

import java.io.*;
import java.util.LinkedList;
import java.util.TreeMap;

@Data
public class FileInputOutput {

    private String orderFilePath;
    private String submissionFilePath;
    private String outputFilePath;
    private StringBuilder content;

//    System.getProperty("user.dir");

    public LinkedList<String> readSubmission() throws Exception{
        if(submissionFilePath.isBlank() || submissionFilePath.isEmpty())
            throw new FileNotFoundException("Submission file is not found");

        try {
          return readSubmissionFile();
        } catch (Exception e) {
            throw new Exception("Submission file read failed");
        }
    }

    private LinkedList<String> readSubmissionFile() throws Exception{
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.submissionFilePath));
            LinkedList<String> data = new LinkedList<>();
            String line = "";
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while(line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException(e);
        }
        return null;
    }

    public LinkedList<String> readOrder() throws Exception{
        if(orderFilePath.isBlank() || orderFilePath.isEmpty())
            throw new FileNotFoundException("Submission file is not found");

        try {
            return readInputFile();
        } catch (Exception e) {
            throw new Exception("Input file read failed");
        }
    }

    private LinkedList<String> readInputFile() throws Exception {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.orderFilePath));
            LinkedList<String> data = new LinkedList<>();
            String line = "";
            line = bufferedReader.readLine();

            while(line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException(e);
        }
        return null;
    }
    public void save() throws IOException {
        try {
            FileWriter writer = new FileWriter(this.outputFilePath);
            writer.write(String.valueOf(this.content));
            writer.flush();
            writer.close();
        }
        catch(IOException e) {
            throw new IOException();
        }
    }

}
