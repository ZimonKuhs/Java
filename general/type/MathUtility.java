package type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathUtility {

    public static double average(List<?> values) {
        if (values.size() == 0) {
            return 0;
        }

        double[] doubles = new double[values.size()];
        int i = 0;

        List<Object> errors = new ArrayList<Object>();
        for (Object value : values) {
            if (!(value instanceof Number)) {
                errors.add(value);
            } else {
                doubles[i++] = ((Number) value).doubleValue();
            }
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(
                    "Can not calculate averages using non-Number elements: "
                            + errors + ".");
        }

        return average(doubles);
    }

    public static double average(long[] values) {
        return average(Arrays.stream(values).asDoubleStream().toArray());
    }

    public static double average(int[] values) {
        return average(Arrays.stream(values).asDoubleStream().toArray());
    }

    public static double average(short[] values) {
        int length = values.length;
        double[] doubles = new double[length];
        for (int i = 0; i < length; ++i) {
            doubles[i] = values[i];
        }
        return average(doubles);
    }

    public static double average(float[] values) {
        int length = values.length;
        double[] doubles = new double[length];
        for (int i = 0; i < length; ++i) {
            doubles[i] = values[i];
        }
        return average(doubles);
    }

    public static double average(double[] values) {
        BigDecimal sum = new BigDecimal(0);

        for (double value : values) {
            sum.add(new BigDecimal(value));
        }
        return sum.divide(new BigDecimal(values.length)).doubleValue();
    }

}
