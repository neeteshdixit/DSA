public class MinimumElement {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6, 9, 4, 1, 2, 3};
        int min = arr[0];
        for(int i = 0; i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("Minimum element in the array is: " + min);
    }
}
