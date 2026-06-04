public class TwoSum1 {
    public static void twosum(int arr[], int target){
        int n = arr.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
            if(arr[i]+arr[j] == target){
                System.out.println(i+" "+j);
            }
            }
        }
        
    }
    public static void main(String[] args) {
        int arr[] = {1,9,3,5,8,66,6,7};
        int target = 13;
        TwoSum1.twosum(arr, target);
    }



}
// arr[i]+arr[j] == target
// [1,9,3,5,8,66,6,7]