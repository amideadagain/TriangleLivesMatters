package com.company;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Persistance {
    public static String SAVE_PATH = "save";

    public static void save(Object obj){
        try {
            FileOutputStream fos = new FileOutputStream(SAVE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> T load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (T) oin.readObject();
    }

    private static String alternativeTo(String path){
        System.out.println("Can't load path: " + path);
        System.out.print("Input file to load: ");
        Scanner s = new Scanner(System.in);
        return s.next();
    };

    private static <T> T load_savetry(String path){
        T res;
        while (true){
            try {
                res = load(path);
                break;
            } catch (Exception e) {
                path = alternativeTo(path);
            }
        }
        makeCopy(path);
        return res;
    }

    public static <T> T load(){
        return load_savetry(SAVE_PATH);
    }

    private static String copyPath(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        return SAVE_PATH + "_" + dtf.format(now);
    }

    private static void makeCopy(String path){
        try {
            FileUtils.copyFile(new File(path), new File(copyPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
