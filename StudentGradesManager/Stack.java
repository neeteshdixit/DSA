package dsa.StudentGradesManager;
public class Stack {
    static int arr[] = new int[5];
    static int top = -1;
    
    static void push(int x){
        if(top == arr.length-1){
            System.out.println("Stack Overflow");
        }
        else{
            top++;
            arr[top] = x;
        }
        // for(int i = top; i>=0; i--){
            System.out.print(arr[top]+" ");
        // }
    }

    static void pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
        }
        else{
            top--;
            //System.out.print(arr[top]+" ");
        }
    }
    public static void main(String[] args) {
        push(6);
        push(8);
        push(9);
        push(10);
        push(11);

        pop();
    }    
}
