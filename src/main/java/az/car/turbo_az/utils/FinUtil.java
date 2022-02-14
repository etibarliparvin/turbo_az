package az.car.turbo_az.utils;

import java.util.List;

public class FinUtil {

    public static boolean checkOneFin(String newFin, String oldFin) {
        return !newFin.equals(oldFin);
    }

    public static boolean checkAllFins(String newFin, List<String> oldFins) {
        return oldFins.stream().noneMatch(a -> a.equals(newFin));
    }
}
