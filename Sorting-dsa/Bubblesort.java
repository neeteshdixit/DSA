import java.util.*;

public class Bubblesort {

    public static void sorted(int nums[]){
        int n = nums.length;

        System.out.println("Sorted array: ");

        for(int i=0; i<n-1; i++){
                for(int j=0; j<n-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
                }
            }
            for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
        }
        
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] nums = new int[size];

        // input
        for(int i = 0; i < size; i++){
            nums[i] = sc.nextInt();
        }

        sorted(nums); // correct call
    }
}