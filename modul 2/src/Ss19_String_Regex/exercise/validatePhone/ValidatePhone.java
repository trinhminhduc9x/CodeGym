package Ss19_String_Regex.exercise.validatePhone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^\\d{2}(-0){1}\\d{9}$";
    public ValidatePhone() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
