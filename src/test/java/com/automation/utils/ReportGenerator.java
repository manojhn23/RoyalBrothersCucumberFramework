package com.automation.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportGenerator {

    public static void main(String[] args) {
        File reportOutputDirectory = new File("new");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("C:\\Capstone-Project\\CapstoneProject\\target\\Android\\cucumber.json");
//
        String buildNumber = "1";
        String projectName = "MyProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Edge");
        configuration.addClassifications("Branch", "release/1.0");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();

//        System.out.println(result.getFormattedDuration());
        // Validate the result if needed
//        if (result.) {
            System.out.println("Report generated successfully.");
//        } else {
//            System.out.println("Report generation failed.");
//        }
    }
}
