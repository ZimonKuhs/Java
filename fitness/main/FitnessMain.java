package main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import file.FileUtility;
import nutrition.CalorieMap;
import nutrition.Report;
import program.ProgramUtility;
import structure.Tuple;

public class FitnessMain {
    private static final String FILE_PATH = "D:\\Kod\\Java\\FitnessUtilities\\src\\data\\intake.txt";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            ProgramUtility
                    .error("File not found: " + file.getAbsolutePath() + ".");
        }

        Report report = new Report(
                new CalorieMap(createMap(FileUtility.readLines(file))));
        System.out.println(report);
    }

    private static Map<Date, Tuple<Double, Integer>> createMap(
            List<String> lines) {
        Map<Date, Tuple<Double, Integer>> map = new LinkedHashMap<Date, Tuple<Double, Integer>>();
        int currentLine = 0;

        for (String line : lines) {
            String[] parts = line.trim().split("\\s+");

            if (parts.length != 3) {
                ProgramUtility.error("Line " + currentLine
                        + " is erroneously formatted. Expected \"<date>\\t<weight>\\t<calories>\".");
            }
            String dateString = parts[0];
            String weight = parts[1];
            String calories = parts[2];

            if (!calories.matches("-?\\d+")) {
                ProgramUtility.error("Line " + currentLine
                        + " is erroneously formatted. The calorie column contained a non-integer: "
                        + calories + ".");
            }

            if (!weight.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                ProgramUtility.error("Line " + currentLine
                        + " is erroneously formatted. The weight column contained a non-float: "
                        + weight + ".");
            }

            Date date = toDate(dateString);

            if (date == null) {
                ProgramUtility.error("Line " + currentLine
                        + " is erroneously formatted. The date column contained a non-date: "
                        + date + ".");
            }

            map.put(date, new Tuple<Double, Integer>(Double.parseDouble(weight),
                    Integer.parseInt(calories)));
            ++currentLine;
        }

        return map;
    }

    private static Date toDate(String string) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(string);
        } catch (ParseException exception) {
            return null;
        }
    }

}
