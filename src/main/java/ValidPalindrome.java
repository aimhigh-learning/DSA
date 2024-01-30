public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));


        System.out.println(isPalindromeOptimize("A man, a plan, a canal: Panama"));

    }


    public static boolean isPalindrome(String s) {

        System.out.println(s);
        // after replace non-alphanumeric chars
        String finalS = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        System.out.println(finalS);

        String reverse = new StringBuffer(finalS).reverse().toString();

        System.out.println(reverse);
        return finalS.equals(reverse) ? true : false;


    }


    public static boolean isPalindromeOptimize(String s) {

        char[] chars = s.toCharArray();
        StringBuilder afterRemoveNonAlthaNumeric = new StringBuilder();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                afterRemoveNonAlthaNumeric.append(String.valueOf(c).toLowerCase());
            }
        }

        System.out.println("afterRemoveNonAlthaNumeric :: " + afterRemoveNonAlthaNumeric.toString());
        return new StringBuffer(afterRemoveNonAlthaNumeric.toString()).reverse().toString().equals(afterRemoveNonAlthaNumeric.toString());
    }
}
