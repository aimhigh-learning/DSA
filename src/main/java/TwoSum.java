import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {

        int[] inp = new int[]{3,2,3};
        System.out.println(Arrays.toString(twoSum(inp, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int L = 0; L<nums.length;L ++) {
            for(int R = L+1; R<=nums.length-1; R++) {
                if (nums[L] + nums[R] == target) {
                    return new int[]{L,R};
                }
            }
        }
        return new int[] {};
    }
}
