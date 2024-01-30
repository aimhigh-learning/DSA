import java.util.Arrays;

public class TwoSumInputArrayIsSorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumGood(new int[]{2,7,11,15}, 9)));

        System.out.println(Arrays.toString(twoSumGood(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSumGood(new int[]{-1,0}, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int sum = 0;


        for(int L =0;L<numbers.length;L++) {
            for (int R=L+1; R<numbers.length;R++) {
                if(numbers[L]+numbers[R] == target) {
                    return new int[] {L+1,R+1};
                }
            }
        }
        return new int[] {};
    }


    public static int[] twoSumGood(int[] numbers , int target ) {
        int i =0;
        int j = numbers.length-1;
        while (i<j) {
            if(numbers[i]+numbers[j]==target) {
                return new int[]{i+1,j+1};
            }
            else if(numbers[i]+numbers[j]>target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }

}
