package rpg.character;

import general.type.StringUtility;
import rpg.system.Constants;
import rpg.system.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Attributes {
    private static final String LONGEST_NAME;
    private final Map<String, Integer> attributes;

    static {
        String res = "";
        for (String name : Constants.ATTRIBUTES) {
            if (res.length() < name.length()) {
                res = name;
            }
        }
        LONGEST_NAME = res;
    }

    /*
     * Constructors.
     */

    public Attributes() {
        this(Constants.DEFAULT_THRESHOLD);
    }

    public Attributes(int threshold) {
        Map<String, Integer> atts = new LinkedHashMap<String, Integer>();
        List<String> names = Constants.ATTRIBUTES;
        int statSum = 0;

        while (statSum < threshold) {
            atts.clear();
            statSum = 0;

            for (int i = 0; i < names.size(); ++i) {
                int stat = Dice.roll(3, 6);
                statSum += stat;
                atts.put(names.get(i), stat);
            }
        }

        this.attributes = atts;
    }

    /*
     * Methods.
     */

    public int get(int index) {
        return get(Constants.ATTRIBUTES.get(index));
    }

    public int get(String name) {
        return attributes.get(name);
    }

    public void reorder(String... strings) {
        reorder(new ArrayList<String>(Arrays.asList(strings)));
    }

    public void reorder(List<String> priority) {
        if (priority.size() > attributes.size()) {
            throw new IllegalArgumentException("Invalid priority order: More stats to prioritize (" + priority.size()
                    + ") than available stats (" + attributes.size() + ").");
        }

        validatePriority(priority);

        if (priority.size() < attributes.size()) {
            for (String name : attributes.keySet()) {
                if (!priority.contains(name)) {
                    priority.add(name);
                }
            }
        }

        List<Integer> sorted = new ArrayList<Integer>(attributes.values());
        Collections.sort(sorted);
        Collections.reverse(sorted);

        while (!(priority.isEmpty() || sorted.isEmpty())) {
            attributes.put(priority.remove(0), sorted.remove(0));
        }

    }

    private void validatePriority(List<String> names) {
        List<String> missing = new ArrayList<String>();
        Set<String> keySet = attributes.keySet();

        for (String name : names) {
            if (!keySet.contains(name)) {
                missing.add(name);
            }
        }

        if (missing.isEmpty()) {
            return;
        }

        throw new IllegalArgumentException(
                "Invalid attribute names found in priority: " + Arrays.toString(missing.toArray()) + ".");
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[\n");

        for (String name : attributes.keySet()) {
            string.append("    ");
            string.append(StringUtility.normalize(name, " ", LONGEST_NAME.length()));
            string.append("    " + get(name) + "\n");
        }

        return string.append("\n]").toString();
    }
}