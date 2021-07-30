package general.program;

import java.util.List;

public class ProgramUtility {

    /*
     * Convenience error methods.
     */

    public static void error() {
        error("The program encountered an unknown error.");
    }

    public static void error(String message) {
        error(message, 1);
    }

    public static void error(String message, int errorCode) {
        System.err.println("Error: " + message);
        System.exit(errorCode);
    }

    public static void error(List<String> errors) {
        error(errors, 1);
    }

    public static void error(List<String> errors, int errorCode) {
        System.err.println("Errors were found:");
        for (String errorLine : errors) {
            System.err.println(errorLine);
        }
        System.exit(errorCode);
    }

}