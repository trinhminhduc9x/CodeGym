package My_exercise.ss1.model;

public class Candidate implements Comparable<Candidate> {
    private int Serial;
    private String Name;
    private String DateOfBirth;
    private double MathScores;
    private double LiteratureScores;
    private double EnglishScores;

    public Candidate() {

    }

    public Candidate(int serial, String name, String dateOfBirth, double mathScores, double literatureScores, double englishScores) {
        Serial = serial;
        Name = name;
        DateOfBirth = dateOfBirth;
        MathScores = mathScores;
        LiteratureScores = literatureScores;
        EnglishScores = englishScores;
    }

    public int getSerial() {
        return Serial;
    }

    public void setSerial(int serial) {
        Serial = serial;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public double getMathScores() {
        return MathScores;
    }

    public void setMathScores(double mathScores) {
        MathScores = mathScores;
    }

    public double getLiteratureScores() {
        return LiteratureScores;
    }

    public void setLiteratureScores(double literatureScores) {
        LiteratureScores = literatureScores;
    }

    public double getEnglishScores() {
        return EnglishScores;
    }

    public void setEnglishScores(double englishScores) {
        EnglishScores = englishScores;
    }

    public double getSum() {
        return LiteratureScores + MathScores + EnglishScores;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "Serial=" + Serial +
                ", Name='" + Name + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", MathScores=" + MathScores +
                ", LiteratureScores=" + LiteratureScores +
                ", EnglishScores=" + EnglishScores +
                ", Sum= " + getSum() +
                '}';
    }

    @Override
    public int compareTo(Candidate o) {
        return o.getName().compareTo(this.getName());
    }
}
