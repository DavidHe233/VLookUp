package vlookup.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private static final String DATA_HEADER = "AA";
    private static final String DATA_TAIL = "BB";
    private static final String DATA_SEPARATOR = "W";

    public static List<Coordinate> parseCoordinates(String data) {
        List<Coordinate> coordinates = new ArrayList<>();
        int[] queue = new int[4];
        int i = 0;
        for (int start = 2, end = 3; end < data.length() - 2; end++) {
            if (data.charAt(end) == 'C') {
                queue[i++] = Integer.parseInt(data.substring(start, end));
                Coordinate coordinate = new Coordinate(queue[1], queue[2], queue[3]);
                coordinates.addLast(coordinate);
                i = 0;
                start = end + 1;
                continue;
            }
            if (data.charAt(end) == DATA_SEPARATOR.charAt(0)) {
                queue[i++] = Integer.parseInt(data.substring(start, end));
                start = end + 1;
            }
        }
        return coordinates;
    }
    
    public static boolean hasCoordinates(String data) {
        return data.contains(DATA_SEPARATOR);
    }
}
