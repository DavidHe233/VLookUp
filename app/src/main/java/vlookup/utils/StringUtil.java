package vlookup.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private static final String DATA_HEADER = "AA";
    private static final String DATA_TAIL = "BB";
    private static final String DATA_SEPARATOR = "W";

    public static List<Coordinate> parseCoordinates(String data) {
        List<Coordinate> coordinates = new ArrayList<>();
        int[] queue = new int[2];
        int i = 0;
        int start, end;
        for (start = 2, end = 3; end < data.length() - 2; end++) {
            if (data.substring(end, end + 1).equals("C")) {
                queue[i] = Integer.parseInt(data.substring(start, end));
                coordinates.add(new Coordinate(queue[0], queue[1]));
                break;
            }
            if (data.substring(end, end + 1).equals(DATA_SEPARATOR)) {
                String coordinate = data.substring(start, end + 1);
                start = end + 1;
                queue[i++] = Integer.parseInt(coordinate);
                if (i == 2) {
                    coordinates.add(new Coordinate(queue[0], queue[1]));
                    i = 0;
                }
            }
        }
        return coordinates;
    }
    
    public static boolean hasCoordinates(String data) {
        return data.contains(DATA_SEPARATOR);
    }
}
