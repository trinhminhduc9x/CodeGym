package Ss17_Io_binary_file_serialization.exercise.util;

import Ss17_Io_binary_file_serialization.exercise.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadAndWrite {
    public static void writeToFile(String pathFile, List<Product> products) {
        File file = new File(pathFile);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream=null;
        try {
           fileOutputStream = new FileOutputStream(file);
           objectOutputStream = new ObjectOutputStream(fileOutputStream);
           objectOutputStream.writeObject(products);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static List<Product> readDataFromFile(String pathFile) {
        List<Product> products = new ArrayList<>();
        File file = new File(pathFile);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream=null;
        try {if (file.length()>0){
           fileInputStream = new FileInputStream(file);
           objectInputStream= new ObjectInputStream(fileInputStream);
           products = (List<Product>) objectInputStream.readObject();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                if (file.length()>0){
                    fileInputStream.close();
                    objectInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
return products;
    }
//    private static void copyFileUsingStream(File source, File target) {
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        try {
//            inputStream = new FileInputStream(source);
//            outputStream = new FileOutputStream(target);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = inputStream.read(buffer)) > 0) {
//                outputStream.write(buffer, 0, length);
//            }
//        } catch (FileNotFoundException exception) {
//            exception.printStackTrace();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        File sourceFile = new File("excer/src/ss17_binaryfile_serialization/excercise/copy/source.dat");
//        File target = new File("excer/src/ss17_binaryfile_serialization/excercise/copy/target.dat");
//        copyFileUsingStream(sourceFile, target);
//        System.out.println("Số byte: " + target.length());
////        Path path = Paths.get("excer/src/ss17_binaryfile_serialization/excercise/copy/target.dat");
////        try {
////            System.out.println("Số byte: " + Files.size(path));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
}
