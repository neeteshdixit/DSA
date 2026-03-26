public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2,3,5,2,2,1,5,7,10,9,7,9,6,5,10};

        // Step 0: find max element
        int maxNum = findMax(arr);
        // maxNum = 10

        // Step 1: create count array
        int[] count = new int[maxNum + 1];
        // count = [0,0,0,0,0,0,0,0,0,0,0]

        // Step 2: frequency count
        for(int num : arr){
            count[num]++;
        }

        /*
        After frequency count:
        arr   = [2,3,5,2,2,1,5,7,10,9,7,9,6,5,10]

        count = [0,1,3,1,0,3,1,2,0,2,2]
                0 1 2 3 4 5 6 7 8 9 10
        (means: 1 appears 1 time, 2 appears 3 times, etc.)
        */

        // Step 3: cumulative frequency
        for(int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }

        /*
        After cumulative sum:
        count = [0,1,4,5,5,8,9,11,11,13,15]

        Meaning:
        - 1 ka last index = 0
        - 2 ka last index = 3
        - 5 ka last index = 7
        - 10 ka last index = 14
        */

        // Step 4: create result array
        int[] result = new int[arr.length];
        // result = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

        // Step 5: fill result array (reverse traversal for stability)
        for(int i = arr.length - 1; i >= 0; i--){
            int value = arr[i];
            int position = count[value] - 1;

            result[position] = value;
            count[value]--;
        }

        /*
        Visualization of filling:

        Step by step (reverse):
        take 10 → place at index 14
        take 5  → place at index 7
        take 6  → place at index 8
        take 9  → place at index 12
        ...

        Final result:
        result = [1,2,2,2,3,5,5,5,6,7,7,9,9,10,10]
        */

        // Step 6: copy back to original array
        for(int i = 0; i < arr.length; i++){
            arr[i] = result[i];
        }

        // Step 7: print sorted array
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    static int findMax(int[] arr){
        int ma = arr[0];
        for(int i = 0; i < arr.length; i++){
            ma = Math.max(ma, arr[i]);
        }
        return ma;
    }
}