public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {10,345,675,744,655,500,660,44,3233};

        // Step 1: find max number
        int ma = arr[0];
        for (int i = 0; i < arr.length; i++) {
            ma = Math.max(ma, arr[i]);
        }
        // max = 3233

        /*
        Radix Sort Idea:
        Sort digit by digit (units → tens → hundreds → thousands)
        */

        // Step 2: apply counting sort for each digit place
        for(int place = 1; ma / place > 0; place *= 10){
            countingSort(arr, place);
        }

        // print sorted array
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static void countingSort(int[] arr, int place){

        int[] count = new int[10]; // digits 0–9

        // Step 1: frequency based on digit
        for(int i = 0; i < arr.length; i++){
            int key = (arr[i] / place) % 10;
            count[key]++;
        }

        /*
        Example (place = 1, units digit):
        arr = [10,345,675,...]

        units digits → [0,5,5,...]
        count = frequency of digits (0–9)
        */

        // Step 2: cumulative sum
        for(int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }

        /*
        count now tells:
        digit k ka last position kya hoga
        */

        int[] result = new int[arr.length];

        // Step 3: build result (reverse for stability)
        for(int i = arr.length - 1; i >= 0; i--){
            int key = (arr[i] / place) % 10;

            int position = count[key] - 1;
            result[position] = arr[i];

            count[key]--;
        }

        /*
        Visualization:
        Suppose units sorting ho raha hai:

        numbers grouped by last digit:
        10 → 0
        345 → 5
        675 → 5

        after placement → partially sorted
        */

        // Step 4: copy back
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
}