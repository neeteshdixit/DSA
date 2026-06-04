
import java.util.Arrays;

public class SquareOfArray{
    public static void sortedArraySquare(int arr[]){
        for(int i = 0; i<arr.length; i++){
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }

    }

    public static void main(String[] args){
        int arr[] = {-4,-1,0,3,10};
        sortedArraySquare(arr);
    }
}