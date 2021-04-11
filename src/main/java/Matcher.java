import java.util.regex.Pattern;

public class Matcher {
    public static boolean matches(String text, String regex) {
        return matches(text, regex, 2000);
    }

    public static boolean matches(String text, String regex, long timeoutMs) {
        return Pattern.compile(regex).matcher(new TimedCharSequence(text, timeoutMs)).matches();
    }
}
