package system;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    public static int roll(int dice, int value) {
        int sum = 0;

        for (int i = 0; i < dice; ++i) {
            sum += random.nextInt(value) + 1;
        }

        return sum;
    }
}
