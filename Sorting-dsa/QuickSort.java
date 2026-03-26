public class QuickSort {

    public int partition(int[] arr, int left, int key) {
        int pivot = arr[key];   // pivot value
        int i = left - 1;

        for (int j = left; j < key; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // pivot ko correct position pe rakhna
        int temp = arr[i + 1];
        arr[i + 1] = arr[key];
        arr[key] = temp;

        return i + 1;   // pivot index return
    }

    public void quicksort(int[] arr, int left, int key) {
        if (left < key) {
            int pi = partition(arr, left, key);

            quicksort(arr, left, pi - 1);
            quicksort(arr, pi + 1, key);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,344222,244,1,2,412,3133,1212};

        QuickSort qs = new QuickSort();
        qs.quicksort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}