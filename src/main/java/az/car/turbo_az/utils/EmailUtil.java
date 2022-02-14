package az.car.turbo_az.utils;

import java.util.List;

public class EmailUtil {

    public static boolean checkOneEmail(String newEmail, String oldEmail) {
        return !newEmail.equals(oldEmail);
    }

    public static boolean checkAllEmails(String newEmail, List<String> oldEmails) {
        return oldEmails.stream().noneMatch(a -> a.equals(newEmail));
    }
}
