import java.util.HashMap;

/**
 * CheckPermutation
 */
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(isPermutation("stop", "pots"));
        System.out.println(isPermutation("pets", "pots"));
        System.out.println(isPermutation("stop3", "pots"));
    }

    public static boolean isPermutation(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap1 = hashMap(string1);
        HashMap<Character, Integer> hashMap2 = hashMap(string2);

        return hashMap1.equals(hashMap2);
    }

    private static HashMap<Character, Integer> hashMap(String string) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : string.toLowerCase().toCharArray()) {
            if (hm.containsKey(c)) {
                hm.replace(c, hm.get(c) + 1); 
            } else {
                hm.put(c, 1);
            }
        }

        return hm;
    }
}