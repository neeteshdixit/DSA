public class FrequencyCount {
    public static void main(String[] args) {
        int arr[] = {1,3,2,4,3,3,3,4,5,6,7,7,8,9,9};
        boolean visited[] = new boolean[arr.length];

        for(int i = 0; i<arr.length; i++){
            if(visited[i] == true){
                continue;
            }
            int count = 0;

            for(int j=0; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    count++;
                    
                visited[j] = true;
                }
            }
            System.out.println("Frequency of " + arr[i] + " is: " + count);
        }
    }
}
