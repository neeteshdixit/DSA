package dsa.Arrayandarraylist;

import java.util.Scanner;
public class Array_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();
        //boolean found = false;

        for(int i = 0; i < size; i++){
            if(arr[i] == target){
                System.out.println("Element found at index: " + i);
                //found = true;
                break;
            }
        }
        if(arr[size-1] != target){
            System.out.println("Element not found");
        }

        sc.close();
    }
}
