public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,3,4,5,6,7,8,9};
        int li = arr[0];
        int hi = arr[arr.length-1];
        int element = 6;
        while(li <= hi){
            int mid = (li+hi)/2;
            if(arr[mid]== element){
                System.out.println(mid);
                
                break;
            }
            if(element > arr[mid]){
                li=mid+1;
            }

            if(element<arr[mid]){
                hi = mid-1;
            }
        }
    }
}
