public class QuickSort {

    public static void partition(int arr[], int low, int high){

        int pivot = arr[low + (high-low)/2];

        int i = low;
        int j = high;

        while(i <= j){

            while(arr[i] < pivot){
                i++;
            }

            while(arr[j] > pivot){
                j--;
            }

            if(i <= j){

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        // left side
        if(low < j){
            partition(arr, low, j);
        }

        // right side
        if(i < high){
            partition(arr, i, high);
        }
    }

    public static void main(String[] args) {

        int arr[] = {12,34,2,321,334,4};

        partition(arr,0,arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}