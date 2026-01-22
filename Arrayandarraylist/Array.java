package dsa.Arrayandarraylist;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<size; i+=2){
            System.out.print(arr[i] + " ");
        }

        sc.close();

    }
}
