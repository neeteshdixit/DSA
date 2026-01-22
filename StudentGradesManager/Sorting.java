package dsa.StudentGradesManager;
public class Sorting {
    //bubble sort
    // bubble sort mein hum array ke adjacent elements ko compare karte hain aur agar pehla element doosre se bada hota hai to unhe swap kar dete hain is process ko hum tab tak repeat karte hain jab tak array sorted na ho jaye
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
       for(int i = 0; i <arr.length; i++){
        for(int j = i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
         System.out.print(arr[i]+" ");
       }
         System.out.println();
       // selection sort 
       // selection sort mein hum array ko do parts mein divide karte hain sorted aur unsorted part mein aur har iteration mein hum unsorted part se sabse chhota element uthate hain aur usse sorted part ke end mein rakh dete hain
       for(int i=0; i<arr.length; i++){
        int smallest = i;
        for(int j = i+1;j<arr.length;j++){
            if(arr[smallest]>arr[j]){
                smallest = j;
            }
        }
        int temp = arr[smallest];
        arr[smallest] = arr[i];
        arr[i] = temp;
        System.out.print(arr[i]+" ");
       }
         System.out.println();
       // insertion sort
       // insertion sort mein hum assume karte hain ki pehla element sorted hai aur baaki elements ko hum uss sorted part mein insert karte hain sahi jagah par mtlb unsorted part se ek element uthate hain aur usse sorted part mein aise jagah par insert karte hain jahan wo sahi position par aa jaye
       for(int i = 0; i<arr.length; i++){
        int current = arr[i];
        int j = i-1;
        while(j>=0 && arr[j]>current){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
        System.out.print(arr[i]+" ");
       }
    } 
}
