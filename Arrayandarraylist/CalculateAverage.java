public class CalculateAverage {
    public static void main(String[] args) {
        int arr[] = {2,3,5,6,9,4,1,2,3};
        int sum = 0;
        float avg = 0;
        for(int i = 0; i<arr.length;i++){
            sum +=arr[i];
            avg = (float)sum / arr.length;
        }
        System.out.println("Average of elements in the array is: " + avg);
    }
}
