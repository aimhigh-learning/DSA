import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findYValue' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER bits
     *  2. INTEGER maxSet
     *  3. STRING x
     */

    public static String findYValue(int bits, int maxSet, String x) {
            List<char[]> result = new ArrayList<>();

        // push default value

        for(int i =0; i<=bits; i++) {
            if(i==0) {
                result.add(blankArray(bits));
            } else {
                char[] chars = blankArray(bits);
                chars[i-1]='1';
                result.add(chars);
            }
            System.out.println(Arrays.toString(result.get(i)));
        }

        List<String> xorOutput = new ArrayList<>();
        for(char[] chars: result) {

            int left =  Integer.parseInt(new String(chars));
            int right =  Integer.parseInt(new String(x));

            // perform xor
            int res = left ^ right;
            xorOutput.add(String.valueOf(res));

        }

        System.out.println(xorOutput);

        // find the max
        String max = xorOutput.get(0);
        int position = 0;
        for(int i=1;i<xorOutput.size();i++) {
            int m = Math.max(Integer.parseInt(max), Integer.parseInt(xorOutput.get(i)));
            if(Integer.parseInt(max)<m) {
                max = xorOutput.get(i);
                position= i;
            }
        }

        System.out.println(max);
        System.out.println(position);



        return new String(result.get(position));

    }

    public static  char[] blankArray(int length) {
        char[] result = new char[length];
        for(int i=0;i<length;i++) {
            result[i] = '0';
        }
        return result;
    }

}

public class FindTheMaxBit {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int bits = Integer.parseInt(bufferedReader.readLine().trim());

        int maxSet = Integer.parseInt(bufferedReader.readLine().trim());

        String x = bufferedReader.readLine();

        String result = Result.findYValue(bits, maxSet, x);

        System.out.println(result);

        bufferedReader.close();

    }
}
