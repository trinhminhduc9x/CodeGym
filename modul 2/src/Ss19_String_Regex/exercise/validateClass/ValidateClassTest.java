package Ss19_String_Regex.exercise.validateClass;
class ValidateClassTest {
    private static ValidateClass validate;
    public static final String[] valiEmail = new String[]{"C0318G"};
    public static final String[] invaliEmail = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        validate = new ValidateClass();
        for (String s : valiEmail) {
            boolean isvalid = validate.validate(s);
            System.out.println("Email is " + s + " is valid: " + isvalid);
        }
        for (String s :
                invaliEmail) {
            boolean isvalid = validate.validate(s);
            System.out.println("Email is " + s + " is valid: " + isvalid);
        }
    }
}