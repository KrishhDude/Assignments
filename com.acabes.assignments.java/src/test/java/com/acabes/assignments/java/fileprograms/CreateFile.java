package com.acabes.assignments.java.fileprograms;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String friend;
        File file = new File("C:\\Users\\User\\Desktop\\thisisafile.txt");
        if (file.createNewFile()) {
            System.out.println("File created.");
        } else {
            throw new FileAlreadyExistsException("A file with that name already exists.");
        }

        FileWriter fileWriter = new FileWriter(file);
        friend = "oru frand";
        fileWriter.write(friend);

        fileWriter.flush();
        fileWriter.close();
    }
}
