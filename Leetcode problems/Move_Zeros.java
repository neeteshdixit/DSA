public class Move_Zeros {
    public static void moveZeros(int arr[]){
        int i =0;
        int j=0;
        while(i<arr.length){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }

        for(int k = 0; k<arr.length; k++){
            System.out.print(arr[k]+" ");
        } 
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        moveZeros(arr);
        
    }
}
