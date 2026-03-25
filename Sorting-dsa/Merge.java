public class Merge {
    public static void merge(int[] arr, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            merge(arr, start, mid);
            merge(arr, mid+1,end);
            combine(arr,start,mid,end);
        }
    } 

    public static void combine(int[] arr,int start,int mid,int end){
        int totalLength = end-start+1;
        int[] c = new int[totalLength];
        int i =start, j = mid+1, k =0;
        while(i<= mid && j<=end){
            if(arr[i]<arr[j]){
                c[k] = arr[i];
                i++;
                k++;
            }
            else{
                c[k]=arr[j];
                j++;
                k++;
            }
        }

        while(i<=mid){
            c[k]=arr[i];
            i++;
            k++;
        }
        while(j<=end){
            c[k]=arr[j];
            j++;
            k++;
        }

        for (i = 0; i < totalLength; i++) {
            arr[start+i] = c[i];
        }
    }

    public static void main(String[] args) {
        int[] arr ={445,45,445,4555,455555545,4775,400695,455,3,1,24424,23,43,32,4,323};
        int n = arr.length;
        merge(arr, 0,n-1 );
        for(int num:arr){
            System.out.println(num+" ");
        }
    }

}
