package Ss19_String_Regex.practice;

class EmailExampleTest {
    private static EmailExample emailExample;
    public static final String[] valiEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invaliEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String[] args) {
     emailExample = new EmailExample();
        for (String s :valiEmail) {
           boolean isvalid = emailExample.validate(s);
            System.out.println("Email is " + s +" is valid: "+ isvalid);
        }
        for (String s:
             invaliEmail) {
            boolean isvalid = emailExample.validate(s);
            System.out.println("Email is " + s +" is valid: "+ isvalid);
        }
    }
}