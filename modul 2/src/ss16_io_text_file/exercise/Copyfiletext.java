package ss16_io_text_file.exercise;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Copyfiletext {
    public static List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }

    public static void writeFile(List<Integer> numbers, String filePath) {
        try {
            File file = new File(filePath);
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < numbers.size(); i++) {
                bufferedWriter.write( numbers.get(i)+"");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "src/ss16_io_text_file/practice/test.txt";
        String path2 = "src/ss16_io_text_file/practice/test2.txt";
        List<Integer> numbers = readFile(path);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        writeFile(numbers, path2);
    }
}
