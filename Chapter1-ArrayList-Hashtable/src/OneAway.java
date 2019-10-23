/**
 * OneAway
 */
public class OneAway {

    public static void main(String[] args) {
        System.out.println(oneAway("ple", "pale"));
        System.out.println(oneAway("pale", "pill"));
    }

    public static boolean oneAway(String string1, String string2) {
        if ((string1.length() - string2.length()) > 1) {
            return false;
        }

        boolean answer = false;
        
        if ((string1.length() - string2.length()) == 1) {
            answer = checkRemoveCharacter(string1, string2);
        }
        
        if ((string1.length() - string2.length()) == 0) {
            answer = checkReplaceCharacter(string1, string2);
        }

        if ((string1.length() - string2.length()) == -1) {
            answer = checkRemoveCharacter(string2, string1);
        }

        return answer;
    }

    private static boolean checkRemoveCharacter(String string1, String string2) {

        for (int i = 0; i < string1.length(); i++) {
            StringBuilder sb = new StringBuilder(string1);
            String checkString = sb.deleteCharAt(i).toString();
            if (checkString.equals(string2)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkReplaceCharacter(String string1, String string2) {
        int difference = 0;
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();

        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] != charArray2[i]) {
                difference++;
            }

            if (difference > 1) {
                return false;
            }
        }

        return true;
    }
}