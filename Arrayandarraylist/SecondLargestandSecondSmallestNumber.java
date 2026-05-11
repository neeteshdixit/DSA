public class SecondLargestandSecondSmallestNumber {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int Largest = arr[0];
        int secondLargest = arr[0];
        int smallest = arr[0];
        int secondSmallest = arr[1];
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>Largest){
                secondLargest = Largest;
                Largest = arr[i];
            }
            if(arr[i]<smallest){
                smallest = arr[i];
            }
            if(arr[i]!=smallest && arr[i]<secondSmallest){
                secondSmallest = arr[i];
            }   
        }
        System.out.println("Largest element in the array is: " + Largest);
        System.out.println("Smallest element in the array is: " + smallest);
        System.out.println("Second largest element in the array is: " + secondLargest);
        System.out.println("Second smallest element in the array is: " + secondSmallest);
    }
}
