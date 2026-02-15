public class Tower_of_hanoi {
    
    public static void toH(int n, String src, String dest, String helper){

    if(n == 0){
        return ;
    }
    toH(n-1,src,helper,dest);
    System.out.println("Move "+n+" disk from "+src+" to "+ dest);
    toH(n-1,helper,dest,src);
    }
public static void main(String[] args) {
    toH(3,"Ab","Bc","Cd");
}
}
