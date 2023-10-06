package com.acabes.assignments.java.fileprograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class UpdateFile {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\User\\Desktop\\thisisafile.txt");
        if(!file.exists()){
            throw new FileNotFoundException("This file does not exist");
        }
        Scanner fileScanner = new Scanner(file);
        FileWriter fileWriter = new FileWriter(file, true);

        System.out.println("Current file contents: ");
        while(fileScanner.hasNextLine()) {
            String fileData = fileScanner.nextLine();
            System.out.println(fileData);
        }

        System.out.println("Appending some text to the file:");
        fileWriter.write("This was appended");


        fileWriter.close();
        fileScanner.close();
    }
}
