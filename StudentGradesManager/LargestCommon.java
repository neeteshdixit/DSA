import java.util.HashSet;
public class LargestCommon {
    public void largestCommonPrefix(int[] arr1, int[] arr2){
        HashSet<String> set = new HashSet<>();

        for(int num:arr2){
            String s = String.valueOf(num);
            String pref = "";
            for(int i = 0; i<s.length(); i++){
                pref += s.charAt(i);
                set.add(pref);
            }
        }

        int ans = 0;
        for(int num:arr1){
            String s = String.valueOf(num);
            String pref = "";
            for(int i = 0; i<s.length(); i++){
                pref += s.charAt(i);
                if(set.contains(pref)){
                    ans = Math.max(ans, pref.length());
                }else{
                    break;
            }
        }
    }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        LargestCommon lc = new LargestCommon();
        int[] arr1 = {1234, 5678, 91011};
        int[] arr2 = {123, 567, 910, 112};
        lc.largestCommonPrefix(arr1, arr2);
    }
}

// this is the leet code problem largest common prefix in two arrays
