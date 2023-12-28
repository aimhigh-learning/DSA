import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagramsBest(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }


    // my try
    public static List<List<String>> groupAnagrams(String[] strs) {
        final List<List<String>> response = new ArrayList<>();
        for(int i = 0; i<strs.length;i++) {
            List<String> elements = new ArrayList<>();
            for(int j=i+1;j<strs.length;j++) {
                String L = strs[i];
                String R = strs[j];
                // continue if the length is not matched
                if(L.length() != R.length()) {
                    continue;
                }
                // start the anagrams
                char[] LChars = L.toCharArray();
                char[] RChars = R.toCharArray();
                Arrays.sort(LChars);
                Arrays.sort(RChars);
                if(new String(LChars).equals(new String(RChars))) {
                    if(!elements.contains(L)) {
                        elements.add(L);
                    }
                    elements.add(R);
                }
            }
            if(!elements.isEmpty()) {
                response.add(elements);
            }
        }
        if(response.isEmpty()) {
            response.add(Collections.singletonList(""));
        }
        return response;
    }

    // suggestion
    public static List<List<String>> groupAnagramsBest(String[] strs) {
        HashMap<String, List<String>> response = new HashMap<>();
        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            response.computeIfAbsent(key, k-> new ArrayList<>());
            response.get(key).add(s);
        }
        return new ArrayList<>(response.values());
    }
}
