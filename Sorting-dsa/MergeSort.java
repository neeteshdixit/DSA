import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] a = {1,34,56,78,90};
        Integer[] b = {33,43,54,65,76,77,555};

        ArrayList<Integer> c = new ArrayList<>();

        int i = 0, j = 0, n = a.length, m = b.length;

        while(i < n && j < m){
            if(a[i] < b[j]){
                c.add(a[i]);
                i++;
            } else {
                c.add(b[j]);
                j++;
            }
        }

        while(i < n){
            c.add(a[i]);
            i++;
        }

        while(j < m){
            c.add(b[j]);
            j++;
        }

        for(int x = 0; x < c.size(); x++){
            System.out.println(c.get(x));
        }
    }
}