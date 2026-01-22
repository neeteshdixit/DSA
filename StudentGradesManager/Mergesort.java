package dsa.StudentGradesManager;
public class Mergesort {
// complexity = O(n log n)
    public static void conquer(int[] arr, int si, int mid, int ei) {
        int merge[] = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        // Merge the two sorted halves
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merge[x++] = arr[idx1++];
            } else {
                merge[x++] = arr[idx2++];
            }
        }

        // Copy remaining elements of left half
        while (idx1 <= mid) {
            merge[x++] = arr[idx1++];
        }

        // Copy remaining elements of right half
        while (idx2 <= ei) {
            merge[x++] = arr[idx2++];
        }

        // Copy back to original array
        for (int i = 0, j = si; i < merge.length; i++, j++) {
            arr[j] = merge[i];
        }
    }

    public static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = (si + (ei - si) / 2);// esme space complexity ki problem aa sakti hai jb hum badi values ko add karenge to iske liye hum (si + (ei - si) / 2) bhi likh sakte hai

        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = {10, 45, 23, 34, 62, 5, 6, 7, 98, 33, 44, 52, 99, 1};
        int n = arr.length;

        divide(arr, 0, n - 1);

        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
