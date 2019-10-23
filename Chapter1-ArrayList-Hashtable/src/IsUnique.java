import java.util.HashMap;

/**
 * IsUnique
 */
public class IsUnique {

    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "abca";
        String string3 = "abcdg";
        String string4 = "123541";
        String string5 = "";

        System.out.println(isUnique(string1));
        System.out.println(isUnique(string2));
        System.out.println(isUnique(string3));
        System.out.println(isUnique(string4));
        System.out.println(isUnique(string5));
    }

    public static boolean isUnique(String s) {
        if (s.length() < 1) {
            System.out.println("No characters in string provided");
            return false;
        }

        HashMap<Character, Boolean> hashMap = new HashMap<>();
        char[] characters = s.toCharArray();
        for (char c : characters) {
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, true);
            } else {
                return false;
            }
        }
        return true;
    }
}