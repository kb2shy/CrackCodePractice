import java.util.HashMap;

/**
 * PalPerm
 */
public class PalPerm {

    public static void main(String[] args) {
        System.out.println(isPalPerm("Tact Coa"));
    }

    public static Boolean isPalPerm(String string) {

        char[] charArray = string.replaceAll(" ", "").toLowerCase().toCharArray();
        if (charArray.length <= 1) {
            return true;
        }
 
        boolean isEvenLength = charArray.length % 2 == 0;
        boolean answer;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : charArray) {
            if (c == ' ') {
                continue;
            }

            if (hashMap.containsKey(c)) {
                hashMap.replace(c, hashMap.get(c), hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        if (isEvenLength) {
            answer = checkEvenLength(hashMap);
        } else {
            answer = checkOddLength(hashMap);
        }

        return answer;
    }

    private static boolean checkEvenLength(HashMap<Character, Integer> hm) {
        for (char c : hm.keySet()) {
            if (hm.get(c) % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkOddLength(HashMap<Character, Integer> hm) {
        int numOfOddChars = 0;
        for (char c : hm.keySet()) {
            if (hm.get(c) % 2 == 1) {
                numOfOddChars++;
            }

            if (numOfOddChars > 1) {
                return false;
            }
        }

        return true;
    }

}