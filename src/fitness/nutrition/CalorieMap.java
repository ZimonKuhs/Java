package fitness.nutrition;

import general.structure.Tuple;
import general.type.StringUtility;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalorieMap {
    private static final DateFormat format = DateFormat.getInstance();
    private final Map<Date, Tuple<Double, Integer>> map;
    private final List<Double> weights;
    private final List<Integer> calories;
    private final Date start;
    private final Date end;

    /*
     * Constructors.
     */

    public CalorieMap(Collection<Date> dates, Collection<Double> weights, Collection<Integer> calories) {
        this(makeMap(dates, weights, calories));
    }

    private static Map<Date, Tuple<Double, Integer>> makeMap(Collection<Date> dates, Collection<Double> weights,
            Collection<Integer> calories) {
        int size = dates.size();
        if (weights.size() < size || calories.size() < size) {
            throw new IllegalArgumentException("More dates than entries. There are " + size + " dates, "
                    + weights.size() + " weights, and " + calories.size() + " calories.");
        }

        Map<Date, Tuple<Double, Integer>> map = new LinkedHashMap<Date, Tuple<Double, Integer>>();
        List<Date> dateList = new ArrayList<Date>(dates);
        List<Double> weightList = new ArrayList<Double>(weights);
        List<Integer> calorieList = new ArrayList<Integer>(calories);

        for (int i = 0; i < size; ++i) {
            map.put(dateList.remove(0), new Tuple<Double, Integer>(weightList.remove(0), calorieList.remove(0)));
        }

        return map;
    }

    public CalorieMap(Map<Date, Tuple<Double, Integer>> map) {
        List<Date> dates = new ArrayList<Date>(map.keySet());
        Collections.sort(dates);

        this.start = dates.get(0);
        this.end = dates.get(dates.size() - 1);

        List<Double> weights = new ArrayList<Double>();
        List<Integer> calories = new ArrayList<Integer>();
        Map<Date, Tuple<Double, Integer>> dataMap = new LinkedHashMap<Date, Tuple<Double, Integer>>();

        for (Date date : dates) {
            Tuple<Double, Integer> entry = map.get(date);
            weights.add(entry.first());
            calories.add(entry.second());
            dataMap.put(date, entry);
        }

        this.weights = Collections.unmodifiableList(weights);
        this.calories = Collections.unmodifiableList(calories);
        this.map = Collections.unmodifiableMap(dataMap);
    }

    /*
     * Methods.
     */

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public double firstWeight() {
        return weights.get(0);
    }

    public double lastWeight() {
        return weights.get(weights.size() - 1);
    }

    public List<Double> startingWeight(int amount) {
        return weights.subList(0, amount);
    }

    public List<Double> finalWeight(int amount) {
        int end = weights.size() - 1;
        return weights.subList(end - amount, end);
    }

    public List<Double> weights() {
        return weights;
    }

    public List<Integer> calories() {
        return calories;
    }

    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        String header = "Date            Weight  kCal\n";
        String dashes = StringUtility.repeat('-', header.length());

        StringBuilder string = new StringBuilder(header + dashes + "\n");

        for (Entry<Date, Tuple<Double, Integer>> entry : map.entrySet()) {
            Tuple<?, ?> value = entry.getValue();
            string.append(toDate(entry.getKey()) + "\t" + value.first() + "\t" + value.second() + "\n");
        }
        string.append(dashes);

        return string.toString();
    }

    private String toDate(Date date) {
        return format.format(date).split("\\s+\\d+:\\d+")[0];
    }
}