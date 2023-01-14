package baiTapThem.utill;

import baiTapThem.model.TourCar;
import baiTapThem.model.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCSV {
    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    private static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeTruckListToCSV(List<Truck> truckList, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < truckList.size(); i++) {
            stringList.add(truckList.get(i).getToCSV());
        }
        writeObjectToCSV(stringList, pathFile, append);
    }
    public static List<Truck> readTruckList(String pathFile) {
        List<Truck> truckList = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            truckList.add(new Truck(array[0], array[1], array[2], array[3], Double.parseDouble(array[4])));
        }
        return truckList;
    }
    public static void writeTourCarListToCSV(List<TourCar> tourCarList, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < tourCarList.size(); i++) {
            stringList.add(tourCarList.get(i).getToCSV());
        }
        writeObjectToCSV(stringList, pathFile, append);
    }
        public static List<TourCar> readTourCarList(String pathFile) {
            List<TourCar> tourCarList = new ArrayList<>();
            List<String> strings = readObjectToCSV(pathFile);
            String[] array;
            for (int i = 0; i < strings.size(); i++) {
                array = strings.get(i).split(",");
                tourCarList.add(new TourCar(array[0], array[1],array[2], array[3],Integer.parseInt(array[4]),array[5]));
            }
        return tourCarList;
    }
//    public static void writeTruckListToCSV(List<Truck> truckList, String pathFile, boolean append) {
//        File file = new File(pathFile);
//        FileWriter fileWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file, append);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            for( Truck s : truckList) {
//                bufferedWriter.write(s.getToCSV());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<Truck> readTruckList(String pathFile) {
//        List<Truck> truckList = new ArrayList<>();
//        File file = new File(pathFile);
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        String line = "";
//        String[] array = null;
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            while ((line = bufferedReader.readLine()) != null) {
//                array = line.split(",");
//                Truck truck = new Truck(array[0], array[1],array[2], array[3],Double.parseDouble(array[4]));
//                truckList.add(truck);
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//        }
//        return truckList;
//    }
//    //-------------------------------------------------------------------------------
//    public static void writeTourCarListToCSV(List<TourCar> tourCarList, String pathFile, boolean append) {
//        File file = new File(pathFile);
//        FileWriter fileWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file, append);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            for( TourCar s : tourCarList) {
//                bufferedWriter.write(s.getToCSV());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<TourCar> readTourCarList(String pathFile) {
//        List<TourCar> tourCarList = new ArrayList<>();
//        File file = new File(pathFile);
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        String line = "";
//        String[] array = null;
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            while ((line = bufferedReader.readLine()) != null) {
//                array = line.split(",");
//                TourCar tourCar = new TourCar(array[0], array[1],array[2], array[3],Integer.parseInt(array[4]),array[5]);
//                tourCarList.add(tourCar);
//                //  public TourCar(String bienKiemSoat, String temHangSanXuat, String namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//        }
//        return tourCarList;
//    }
}
