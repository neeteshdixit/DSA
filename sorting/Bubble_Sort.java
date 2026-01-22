package sorting;

import java.util.*;
public class Bubble_Sort {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the size of an array");
       int size = sc.nextInt();
       int [] arr = new int[size];
       for (int i = 0; i < 10; i++) {
           arr[i] = sc.nextInt();
       }

       for (int i = 0; i < size; i++) {
           for(int j = i+1; j<size; j++){
            if(arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
           }
       }
       System.out.println("sorted array");
    }
}
