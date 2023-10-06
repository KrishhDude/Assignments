package com.acabes.assignments.java.fileprograms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFileExtensionSize {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\Desktop\\samplepdf.pdf");
        if (!file.createNewFile()) {
            String fileName = file.getName();
            int lastIndex = fileName.lastIndexOf(".");
            System.out.println("File extension : " + fileName.substring(lastIndex, fileName.length()));

            float size = Files.size(Paths.get(String.valueOf(file)));
            System.out.println("Size of the file : " + size/1024 + " KB");
        }
    }
}