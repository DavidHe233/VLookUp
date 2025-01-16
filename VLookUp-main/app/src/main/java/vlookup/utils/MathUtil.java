package vlookup.utils;

import java.util.List;

public class MathUtil {
    public static double standardDeviation(List<Integer> list) {
        double sum = 0;
        for (int i : list) {
            sum += Math.pow(i, 2) - i;
        }
        return Math.sqrt(sum / list.size());
    }
}
