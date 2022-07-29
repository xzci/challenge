package org.example;

import org.example.fileInputOutput.FileInputOutput;
import org.example.result.Calculation;
import org.example.submission.SubmissionFactory;

import java.util.LinkedList;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputOutput io = new FileInputOutput();
        io.setOrderFilePath(System.getProperty("user.dir") + "/test/resources/Submission.txt");
        io.setOutputFilePath(System.getProperty("user.dir") + "/test/resources/Input.txt");
        io.setSubmissionFilePath(System.getProperty("user.dir") + "/test/resources/output");



    }


}