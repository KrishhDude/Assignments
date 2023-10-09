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
            float fileOutputStreamTime = System.currentTimeMillis() - start;
            System.out.println("Writing by FileOutputStream: " + fileOutputStreamTime + "ms");
            fileOutputStream.close();

            /*FileWriter*/
            FileWriter fileWriter = new FileWriter(file);
            start = System.currentTimeMillis();
            for(i=0; i<1000000; i++){
                fileWriter.write(i + " ");
            }
            float FileWriterTime = System.currentTimeMillis() - start;
            System.out.println("Writing by FileWriter: " + FileWriterTime + "ms");

            /*BufferedWriter*/
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            start = System.currentTimeMillis();
            for(i=0; i<1000000; i++){
                bufferedWriter.write((int) i);
            }
            float BufferedWriterTime = System.currentTimeMillis() - start;
            System.out.println("Writing by BufferedWriter: " + BufferedWriterTime + "ms");
            bufferedWriter.close();
            fileWriter.close();


            System.out.println("\nBuffered Writer is " + ((1-(BufferedWriterTime/FileWriterTime))*100) + "% faster than FileWriter" +
                                "\n and " + ((1-(BufferedWriterTime/fileOutputStreamTime))*100) + "% faster than FileOutputStream");

            /*FileInputStream*/
            FileInputStream fileInput = new FileInputStream(file);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
            start = System.currentTimeMillis();
            while((bufferedInput.read()) != -1){}
            int bufferedInputTime = (int) (System.currentTimeMillis() - start);
            System.out.println("\n\nReading by BufferedInputStream: " + bufferedInputTime + "ms");
            bufferedInput.close();
            fileInput.close();

            /*BufferedReader*/
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            start = System.currentTimeMillis();
            while((bufferedReader.readLine()) != null){}
            int bufferedReaderTime = (int) (System.currentTimeMillis() - start);
            System.out.println("Reading by BufferedReader: " + bufferedReaderTime + "ms");
            bufferedReader.close();
            fileReader.close();

            /*Scanner Class*/
            Scanner fileScanner = new Scanner(file);
            start = System.currentTimeMillis();
            while(fileScanner.hasNextLine()){
                String s = fileScanner.nextLine();
            }
            int scannerTime = (int) (System.currentTimeMillis() - start);
            System.out.println("Reading by Scanner: " + scannerTime + "ms");
            fileScanner.close();

            /*System.out.println("\nBufferedReader is " + ((1-(bufferedReaderTime/bufferedInputTime))*100) + "% faster than BufferedInputStream" +
                    "\n and " + ((1-(bufferedReaderTime/scannerTime))*100) + "% faster than Scanner Class");*/


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
