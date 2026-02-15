public class Recursion{

    public static void pD(int n){
        if(n==0){
            return ;
        }
        System.out.println(n);
        pD(n-1);
    }

    public static void pI(int n){
        if(n==0){
            return;
        }

        pI(n-1);
        System.out.println(n);

    }

    public static void pDI(int n){
        if(n==0){
            return;
        }
        System.out.println("Hello "+n);
        pDI(n-1);
        System.out.println("Bye "+n);
    }

    public static void main(String[] args) {
        System.out.println("dereading order:-");
        pD(4);

        System.out.println("increasing order:-");
        pI(4);

        System.out.println("Ass+dess ");
        pDI(4);
    }
} 