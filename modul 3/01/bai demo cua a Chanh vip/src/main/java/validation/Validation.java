package validation;

public class Validation {
    public static boolean checkEmail(String email){
        String regexEmail = "^[a-z]+\\.\\w+\\@[a-z]{2,}\\.[a-z]{2,}$";
        return email.matches(regexEmail);
    }
}
