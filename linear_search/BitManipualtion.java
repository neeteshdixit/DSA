package dsa.linear_search;
public class BitManipualtion {
    // get bit
    // in get bit we use and operation eske help se hum pta karte hai ki bit ki pposition pr kon si bit hai 0 ya 1 
    public static void main(String args[]){
        int n = 5; //number binary = 0101
        int  pos = 2; //position 
        int bitmask = 1<<pos; 
        if((bitmask & n) == 0){
            System.out.println("bit was zero");
        }
        else{
            System.out.println("bit was one");
        }


        // set bit   
        // set bit mein hum use karte hai or operation esme hum bit ko hi change kar dete hai 0 ko 1 aur 1 ko 0 
        int newnumber =  bitmask | n;
        System.out.println(newnumber);
        
        // clear bit 
        // clear bit mein hum use karte hai and operation aur not operation esme hum bit ko 0 kar dete hai mtlb and ke sath bitmash ka not operation use karte hai 
        int newnumber2 = (~bitmask) & n;
        System.out.println(newnumber2);

        // update bit
        // update bit mein hum use karte hai or , and aur not operation esme hum bit ko 0 ya 1 dono kar sakte hai
    }

   

   
}
