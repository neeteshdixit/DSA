
// public class ArrayMethod{
//     public static void main(String[] args) {
//         // List<Integer> list = new ArrayList<>();
//         // list.add(10);
//         // list.add(20);
//         // list.add(30); ye pehla tarika hai we can insert the element using add method

//         // List<Integer> list = Arrays.asList(10,20,30); // ye dusra tarika hai we can directly insert the element using asList method

//          // arrays sort method
            
//         // int[] arr= {5,2,8,1,4};
//         // Arrays.sort(arr);
//         // System.out.println(arr);
//         // int[] arr= {1,9,7,3,5,6,7,4,8,4};
//         // Arrays.sort(arr,3,8 ); using range 3 to 8th index
//         // System.out.println(Arrays.toString(arr));
        

//         // searching element in arr  

//         // int[] arr= {1,9,7,3,5,6,7,4,8,10,2};
//         // Arrays.sort(arr);
//         // int key = 7;
//         // O(log N) time complexity
//         // int index = Arrays.binarySearch(arr, key);
//         // int index = Arrays.binarySearch(arr, 3, 8, key); // using range 3 to 8th index
//         // System.out.println("index of :"+index);
        

//         // fill method
//         // int arr[] = new int[30];
//         // Arrays.fill(arr, 3);
//         // System.out.println(Arrays.toString(arr));

//     }
// }

import java.util.Arrays;

class Tuple implements Comparable<Tuple>{
    public int a,b;

    public Tuple(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Tuple other) {
        if (this.a != other.a) {
            return Integer.compare(this.a, other.a);
        }
        return Integer.compare(this.b, other.b);
    }

    @Override
    public String toString(){
        return "a=" + a + " b=" + b;
    }
}

public class ArrayMethod{
    public static void main(String[] args) {

        Tuple[] arr = new Tuple[4];
        arr[0] = new Tuple(1,2);
        arr[1] = new Tuple(3,4);
        arr[2] = new Tuple(5,6);
        arr[3] = new Tuple(7,8);

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}