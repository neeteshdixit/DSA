
import java.util.HashSet;

public class RemoveDuplicates{
    public static void removeDuplicates(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            set.add(arr[i]);
        }
        for(int num:set){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,2,3,4,5};
        removeDuplicates(arr);
    }
}