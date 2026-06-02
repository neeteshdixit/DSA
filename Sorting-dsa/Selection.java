public class Selection {


    static void selection(int arr[]){
        for(int i = 0; i< arr.length; i++){
            int min = i;
            int temp =0;

            for(int j = i+1; j<arr.length; j++){
                if(arr[j]<arr[min]){
                    min =j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] ={2,5,1,3,4,6,7,43,3,4,243};
        selection(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}