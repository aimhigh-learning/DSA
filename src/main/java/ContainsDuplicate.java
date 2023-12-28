import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(execute());
    }

    public static boolean execute(){
        int[] inp = new int[]{1,1,1,3,3,4,3,2,4,2};
        Arrays.sort(inp);
        for (int i=0;i<inp.length;i++) {
            if(inp[i]==inp[i+1]) {
                return true;
            }
        }
        return false;
    }
}
