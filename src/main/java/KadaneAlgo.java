import java.util.Arrays;

public class KadaneAlgo {


    public static void main(String[] args) {

        // find a non-empty subarray with the largest sum.

        int[] input = new int[]{4,-1,2,-7,3,4};

        // withoutAlgo
        System.out.println("Without algo : " + withoutAlgo(input));

        // approach 1 with algo
        System.out.println("With algo : " + approach1WithAlgo(input));


        // Return the left and right index of the max subarray sum, assuming there's exactly one result
        // Sliding window variation of kadane's O(n)
        System.out.println(Arrays.toString(returnTheMaxWithSubarrayPosition(input)));



    }

    public static int withoutAlgo(int[] input) {
        int max = input[0];
        for(int i =0; i<input.length;i++) {
            int sum = 0;
            for(int j = i+1; j<input.length;j++) {
                sum += input[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int approach1WithAlgo(int[] input) {
        int max = input[0];
        int curSum = 0;
        for (int i =0; i<input.length; i++) {
            curSum = Math.max(curSum, 0);
            curSum += input[i];
            max = Math.max(max, curSum);
        }
        return max;
    }

    public static int[] returnTheMaxWithSubarrayPosition(int[] input) {
        int max = input[0];
        int curSum = 0;
        int maxL = 0; int maxR = 0;
        int L = 0;

        for(int R =0; R<input.length; R++) {
            if(curSum<0) {
                curSum = 0;
                L = R;
            }
            curSum += input[R];

            if(curSum>max) {
                max = curSum;
                maxL = L;
                maxR = R;
            }
        }
        return new int[]{maxL,maxR};
    }
}
