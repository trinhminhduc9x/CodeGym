package service;

public class CalcutatorService {
    public  String getAddition(double a, double b) {
        double result = a + b;
        return   "" + result;
    }
    public String getSubtraction(double a, double b) {
        double result = a - b;
        return  "" + result;
    }
    public String getMultiplication(double a, double b) {
        double result = a * b;
        return  "" + result;
    }
    public String getDivision(double a, double b) {
        if (b == 0){
            return "không chia được cho 0";
        } else {
            double result = a / b;
            return  "" + result;
        }
    }
    public  String calculate(double a, double b, String operator){
        String result="";
        switch (operator){
            case "+":
                result = getAddition(a,b);
                break;
            case "-":
                result = getSubtraction(a,b);
                break;
            case "*":
                result = getMultiplication(a,b);
                break;
            case "/":
                result = getDivision(a,b);
                break;
        }
        return result;
    }
}

