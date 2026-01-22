package sorting;

import java.util.Scanner;

public class Selection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        selectionSort(arr);

        System.out.println("Sorted Array:");
        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n-1; i++){
            int minIndex = i;

            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            // swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
