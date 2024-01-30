import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(productExceptSelfGood(new int[]{1, 2, 3, 4})));

        System.out.println(Arrays.toString(productExceptSelfGood(new int[]{-1,1,0,-3,3})));

    }


    // not good for large data
    public static int[] productExceptSelf(int[] nums) {
        int[] finalResponse = new int[nums.length];
        for (int i =0;i<nums.length;i++) {
            List<Integer> cloneArray =  Arrays.stream(nums).boxed().collect(Collectors.toList());
            cloneArray.remove(i);
            int sum = cloneArray.stream().reduce((a,b)-> a*b).get();
            finalResponse[i]=sum;
        }
        return finalResponse;
    }

    // good for large array data
    public static int[] productExceptSelfGood(int[] nums) {
        int[] finalResponse = new int[nums.length];
        int initial = 1;
        for (int i =0;i<nums.length;i++) {
           finalResponse[i] = initial;
           initial = initial * nums[i];
        }
        initial = 1;
        for (int j = nums.length-1; j>=0;j--) {
            finalResponse[j] = finalResponse[j] * initial;
            initial = initial * nums[j];
        }
        return finalResponse;
    }
}
