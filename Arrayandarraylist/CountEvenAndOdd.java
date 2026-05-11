public class CountEvenAndOdd {
    public static void main(String[] args) {
        int arr[] = {2,4,3,5,6,7,8,10,55,67,66,88};
        int evenCount = 0;
        int oddCount = 0;
        for(int i= 0; i<arr.length; i++){
            if(arr[i]%2 == 0){
                evenCount++;
            }
            else{
                oddCount++;
            }
        }
        System.out.println("Number of even elements in the array is: " + evenCount);
        System.out.println("Number of odd elements in the array is: " + oddCount);
    }
}
