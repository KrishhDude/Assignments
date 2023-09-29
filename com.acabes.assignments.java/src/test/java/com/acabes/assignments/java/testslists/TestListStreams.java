package com.acabes.assignments.java.testslists;

import java.util.*;

public class TestListStreams {

    static void ifNameExists(List<String> list, String nameToSearch){

        list.stream().forEach(i -> {
            if(Objects.equals(i, nameToSearch)){
                System.out.println("Name exists at: " + (list.indexOf(i)+1));
            }
        });
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> myList = new ArrayList<>(10);
        Iterator<String> iter = myList.iterator();

        String nameToSearch;

        System.out.println("Enter names");
        for(int i=0; i<10; i++){
            myList.add(sc.nextLine());
        }

        System.out.println("Enter a name to be searched within a string");
        nameToSearch = sc.nextLine();
        ifNameExists(myList, nameToSearch);
    }
}
