package com.acabes.assignments.java.fileprograms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CheckIfFileExist {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\User\\Desktop\\a new file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                throw new FileAlreadyExistsException("The file already exists");
            }
            FileWriter fileWriter = new FileWriter(file);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string to be added to file:");

            fileWriter.write(sc.next());
            fileWriter.write("Helloo\n");
            fileWriter.write("I am writing to a file..");
            fileWriter.close();

            Scanner fileScanner = new Scanner(file);
            System.out.println("Current file contents: ");
            while (fileScanner.hasNextLine()) {
                String fileData = fileScanner.nextLine();
                System.out.println(fileData);
            }
            fileScanner.close();

        } catch (FileAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
