import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopkFrequentElements {
    public static void main(String[] args) {

        int[] input1 = new int[]{-1,-1};
        System.out.println(Arrays.toString(topKFrequent(input1, 1)));


        int[] input2 = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(input2, 2)));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementsAndFrequency = new HashMap<>();
        for(int num : nums) {
            elementsAndFrequency.computeIfAbsent(num, n-> 0);
            elementsAndFrequency.put(num, elementsAndFrequency.get(num)+1);
        }
        Map<Integer, Integer> sortedMapWithFrequency= elementsAndFrequency.entrySet().stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)-> e1, LinkedHashMap::new
                ));
        int[] finalArray = sortedMapWithFrequency.keySet().stream().mapToInt(x-> x).toArray();
        return Arrays.copyOfRange(finalArray, 0, k);
    }
}
