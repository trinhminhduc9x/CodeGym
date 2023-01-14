package Ss17_Io_binary_file_serialization.exercise.optional;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>();
        stringList1.add("assssss");
        stringList1.add("asdasd");
        stringList1.add("Asdasssss");
        String link1 = "src/Ss17_Io_binary_file_serialization/exercise/optional/link1.csv";
        String link2 = "src/Ss17_Io_binary_file_serialization/exercise/optional/link2.csv";
        copyFile.writeToFile(link1, stringList1);
        List<String> stringList = copyFile.readDataFromFile(link1);
        copyFile.writeToFile(link2, stringList);
    }
}
