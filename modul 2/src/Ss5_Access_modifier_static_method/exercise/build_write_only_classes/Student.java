package Ss5_Access_modifier_static_method.exercise.build_write_only_classes;

public class Student {
    private  String name="john";
    private String classes = " CO2";
    public Student(){}

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
    public void display (){
        System.out.println("name : "+ getName()+"\n class : " + getClasses() );
    }
}
