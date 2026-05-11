public class MaximumElement{
    public static void main(String[] args) {
        int arr[]={2,3,4,5,6,9,4,1,2,3};
        int max = arr[0];
        for (int i = 0; i < 10; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Maximum element in the array is: " + max);
    }
}