package type;

public class StringUtility {

    /*
     * Utility classes should never be instantiated.
     */
    private StringUtility() {
    }

    public static String repeat(char character, int repetitions) {
        return repeat("" + character, repetitions);
    }

    public static String repeat(String string, int repetitions) {
        return normalize("", string, repetitions);
    }

    public static String normalize(String base, String padding, int length) {
        int baseLength = base.length();

        if (baseLength >= length) {
            return base.substring(0, length);
        }

        String filled = base;
        for (int i = baseLength; i < length; ++i) {
            filled = filled + padding;
        }
        return filled;
    }

    public static boolean isPositiveInteger(String string) {
        for (int i = 0; i < string.length(); ++i) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInteger(String string) {
        return isPositiveInteger(string.substring(string.charAt(0) == '-' ? 1 : 0, string.length()));

    }

    public static boolean isFloat(String string) {
        String[] parts = string.split("\\.");
        if (parts.length > 2) {
            return false;
        }

        if (parts.length == 1) {
            return isInteger(parts[0]);
        }

        return isInteger(parts[0]) && isPositiveInteger(parts[1]);
    }

    public static boolean isPositiveFloat(String string) {
        if (string.charAt(0) == '-') {
            return false;
        }
        return isFloat(string);
    }

}