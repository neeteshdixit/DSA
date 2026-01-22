package dsa.Arrayandarraylist;

import java.util.Scanner;

public class Binary_Searching_In_2d_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[][] = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();

        int row = 0;
        int col = size - 1;

        while (row < size && col >= 0) {
            if (arr[row][col] == target) {
                System.out.println("Target found at index " + row + " " + col);
                return;
            } else if (arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        System.out.println("Target not found");
    }
}
