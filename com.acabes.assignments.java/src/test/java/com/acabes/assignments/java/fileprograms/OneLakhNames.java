package com.acabes.assignments.java.fileprograms;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OneLakhNames {
    public static void main(String[] args) {
        int i;

        File file = new File("C:\\Users\\User\\Desktop\\one lakh items lol.txt");
        Path path = Paths.get("C:\\Users\\User\\Desktop\\one lakh items lol.txt") ;
        try {
            if(file.createNewFile()) {
                System.out.println("File Created");
            } else {
                //throw new FileAlreadyExistsException("The file already exists");
                Files.deleteIfExists(path);
            }

            /*FileOutputStream*/
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            long start = System.currentTimeMillis();
            for(i = 0; i<1000000; i++){
                fileOutputStream.write(i);
            }
            System.out.println("Writing by FileOutputStream: " + (System.currentTimeMillis() - start) + "ms");
            fileOutputStream.close();

            /*FileWriter*/
            FileWriter fileWriter = new FileWriter(file);
            start = System.currentTimeMillis();
            for(i=0; i<1000000; i++){
                fileWriter.write(i + " ");
            }
            System.out.println("Writing by FileWriter: " + (System.currentTimeMillis() - start) + "ms");
            fileWriter.close();

            /*BufferedWriter*/
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            start = System.currentTimeMillis();
            for(i=0; i<1000000; i++){
                bufferedWriter.write((int) i);
            }
            System.out.println("Writing by BufferedWriter: " + (System.currentTimeMillis() - start) + "ms");
            bufferedWriter.close();

            /*FileInputStream*/
            FileInputStream fileInput = new FileInputStream(file);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
            start = System.currentTimeMillis();
            while((bufferedInput.read()) != -1){}
            System.out.println("\n\nReading by BufferedInputStream: " + (System.currentTimeMillis() - start) + "ms");
            bufferedInput.close();
            fileInput.close();

            /*BufferedReader*/
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            start = System.currentTimeMillis();
            while((bufferedReader.readLine()) != null){}
            System.out.println("Reading by BufferedReader: " + (System.currentTimeMillis() - start) + "ms");
            bufferedReader.close();
            fileReader.close();

            /*Scanner Class*/
            Scanner fileScanner = new Scanner(file);
            start = System.currentTimeMillis();
            while(fileScanner.hasNextLine()){
                String s = fileScanner.nextLine();
            }
            System.out.println("Reading by Scanner: " + (System.currentTimeMillis() - start) + "ms");
            fileScanner.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
