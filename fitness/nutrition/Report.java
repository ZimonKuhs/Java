package nutrition;

import java.util.concurrent.TimeUnit;

import type.MathUtility;

public class Report {
    private final CalorieMap map;

    public Report(CalorieMap map) {
        this.map = map;
    }

    public long duration() {
        return TimeUnit.DAYS.convert(
                map.start().getTime() - map.end().getTime(),
                TimeUnit.MILLISECONDS);
    }

    public double weightLoss() {
        return map.firstWeight() - map.lastWeight();
    }

    public int tdee() {
        int days = map.size();
        int half = days / 2;

        double startingWeight = MathUtility.average(map.startingWeight(half));
        double finalWeight = MathUtility.average(map.finalWeight(half));

        // TODO: Complete method.

        return Integer.MIN_VALUE;
    }

    public String summary() {
        StringBuilder string = new StringBuilder();
        string.append("Duration: " + duration() + "\n");
        string.append("TDEE: " + tdee() + "\n");
        string.append("Weight loss: " + weightLoss() + "\n");

        string.append("Average weight: " + MathUtility.average(map.weights()));
        string.append("Average kCal: " + MathUtility.average(map.calories()));
        return string.append("\n").toString();
    }

    @Override
    public String toString() {
        return map + summary();
    }
}
