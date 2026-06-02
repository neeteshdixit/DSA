// when array is unsorted or bole ki duplicate remove krdo
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
        int arr1[] = {1,1,2,2,3,3,4,4,5,5};
        removeDuplicates(arr);
        System.out.println();
        removeSortedArrayDuplicates(arr1);
    }
// ====================SORTED ARRAY DUPLICATES REMOVE ====================
    public static void removeSortedArrayDuplicates(int arr1[]){
        int i = 0;
        for(int j =1; j<arr1.length; j++){
            if(arr1[i]!=arr1[j]){
                i++;
                arr1[i] =arr1[j];
            }
        }
        for(int k = 0; k<=i; k++){
            System.out.print(arr1[k]+" ");
        }
    }
}