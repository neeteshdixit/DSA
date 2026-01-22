    package sorting;

    import java.util.Scanner;

    public class Insertion_Sort {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int size = sc.nextInt();
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
            for(int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    System.out.println("Sorted array:");
            for(int i = 0; i < size; i++){
                System.out.print(arr[i] + " ");
            }
        }
    }
