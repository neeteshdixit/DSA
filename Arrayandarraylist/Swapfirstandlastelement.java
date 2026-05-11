public class Swapfirstandlastelement {
    public static void main(String[] args) {
        int arr[] = {1,3,2,4,3,3,3,4,5,6,7,7,8,8,9,9};
        int temp = arr[0];
        arr[0]=arr[arr.length-1];
        arr[arr.length-1] = temp;
        System.out.println("Array after swapping first and last element is: ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
