package utilities;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Utilities {
    public static String formatString(String string) {
        return Arrays.stream(string.split(" "))
                .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
