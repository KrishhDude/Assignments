package com.acabes.assignments.java.sortableinterface;

import java.util.Arrays;
import java.util.Scanner;
interface sortable{
    abstract void sortItems(int[] array);
}

class QuickSort implements sortable{
    public void sortItems(int[] array){
        Arrays.sort(array);
        String arr = Arrays.toString(array);
        System.out.println("After Quick Sort: " + arr);
    }
}

class MergeSort implements sortable{
    public void sortItems(int[] array) {
        Arrays.sort(array);
        String arr = Arrays.toString(array);
        System.out.println("After Merge Sort: " + arr);
    }
}
public class SortableMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        int n=sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++)
        {
            array[i]=sc.nextInt();
        }

        QuickSort quick = new QuickSort();
        MergeSort merge = new MergeSort();

        quick.sortItems(array);
        merge.sortItems(array);
    }
}
