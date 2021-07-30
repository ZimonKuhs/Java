package challenges.euler;

import general.program.ProgramUtility;
import general.type.StringUtility;

public class EulerMain {

    public static void main(String[] args) {
        if (args.length != 1) {
            error();
        }

        String numberString = args[0];
        if (!StringUtility.isInteger(numberString)) {
            error("Usage: ./euler <problem number>")
        }

        Class<?> euler = Class.forName("Euler" + )
    }

}

private void error(String message) {
    ProgramUtility.error(message);
}