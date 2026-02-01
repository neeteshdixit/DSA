import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int[] nums = {1, 3, 4, 5, 5};
        int target = 5;

        int[] result = ts.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
