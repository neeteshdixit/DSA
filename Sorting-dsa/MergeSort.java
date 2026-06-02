public class MergeSort{

    public static void mergeSort(int arr[], int low, int high){
        if(low<high){
            int mid = low +(high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int temp[] = new int[high-low+1];
        int k = 0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k] = arr[left];
                left++;
            } else{
                temp[k] = arr[right];
                right++;
            }
            k++;
        }
        // left remaining
        while(left<=mid){
            temp[k] = arr[left];
            left++;
            k++;
        }

        //right remaining
        while(right<=high){
            temp[k] = arr[right];
            right++;
            k++;
        }

        for(int i = 0; i<temp.length; i++){
            arr[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,3,54,2,55,2,2,34,45};
        mergeSort(arr,0,arr.length-1);

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}