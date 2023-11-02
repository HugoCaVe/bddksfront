package com.ksfront.pom.utils;

import net.thucydides.core.steps.StepInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class Utilities {
    private static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);
    private static final Integer TIME_ADD = 1000;
    private Utilities() {}
    public static int generateRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    public static String concatenateInformation(int limit, String textInformation) {
        int idNumber = generateRandomNumber(limit);
        String numberInformation= String.valueOf(idNumber);
        return (textInformation + numberInformation);
    }

    public static Map<String, String> userDataFilter(String idFilter, String fileName) throws IOException {
        List<Map<String, String>> listLocation =
                CsvUtils.getDataTest(fileName, idFilter);
        return listLocation.get(0);
    }

    public static void waitTime(Integer totalTime) {
        try {
            Thread.sleep((long) totalTime * TIME_ADD);
        } catch (Exception e) {
            LOGGER.error("Waiting error" + e);
        }
    }
}
