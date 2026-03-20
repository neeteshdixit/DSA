public class Selection {
    public static void main(String[] args) {

        int[] arr = {10,2,98,45,32,45,2,3,4};
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int highest = arr[0];
            int indexOfHighestElement = 0;

            for (int j = 0; j < n - i; j++){
                if(arr[j] > highest){
                    highest = arr[j];
                    indexOfHighestElement = j;
                }
            }

            int temp = arr[indexOfHighestElement];
            arr[indexOfHighestElement] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // ✅ Print sorted array
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}