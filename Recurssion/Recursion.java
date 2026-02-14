public class Recursion{

    public static void pD(int n){
        if(n==4){
            return ;
        }
        System.out.println(n);
        pD(n+1);
    }
    public static void main(String[] args) {
        pD(1);
    }
}