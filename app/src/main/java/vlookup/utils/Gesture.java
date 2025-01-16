package vlookup.utils;

import java.util.ArrayList;
import java.util.List;
import vlookup.utils.*;
public class Gesture {
    public static boolean isSameLevel(List<Coordinate> coordinates) {
        List<Integer> x = new ArrayList<>();
        for (Coordinate c : coordinates) {
            x.add(c.y());
        }
        double sd = MathUtil.standardDeviation(x);
        return sd < 10;
    }
    public static void checkgesture(String data){
        List<Coordinate> temp=StringUtil.parseCoordinates(data);
isSameLevel(temp);
    }
}
