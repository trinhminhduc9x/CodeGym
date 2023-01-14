package ss16_io_text_file.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    public static List<Nation> readStudentFileCSV(String pathFile) {
        List<Nation> nationList = new ArrayList<Nation>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line ="";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Nation nation = new Nation(Integer.parseInt(array[0]), array[1], array[2]);
                nationList.add(nation);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return nationList;
    }

    public static void main(String[] args) {

        List<Nation> nationList = readStudentFileCSV("src/ss16_io_text_file/exercise/test.csv");
      //  List<Integer> numbers = readFile(path);
        for (int i = 0; i <nationList.size(); i++) {
            System.out.println(nationList.get(i).getName());
        }
    }
}
