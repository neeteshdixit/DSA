import java.util.Arrays;
public class Sort_0_1_2 {
    public static void sort(int arr[]){
        int zero = 0, one = 0, two=0;
        for(int ar: arr){
            if(ar==0){
                zero++;
            } else if(ar==1){
                one++;
            } else{
                two++;
            }
        }

        int i = 0;
        while(zero>0){
            arr[i]=0;
            i++;
            zero--;
        }

        while(one>0){
            arr[i]=1;
            i++;
            one--;
        }

        while(two>0){
            arr[i]=2;
            i++;
            two--;
        }

        for(int j = 0; j < arr.length; j++){
            System.out.print(arr[j]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,0,1,2,0,1,2};
        sort(arr);
    }
}
