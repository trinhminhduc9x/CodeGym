package Ss19_String_Regex.exercise.validateClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^(A|C|P)\\d{4}(G|H|I|K|L|M)$";
    public ValidateClass() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
