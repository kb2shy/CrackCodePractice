import java.util.HashMap;

/**
 * StringCompression
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressString("compressed"));
    }

    public static String compressString(String input) {
        StringBuilder newString = new StringBuilder();
        char[] check = input.toCharArray();
        
        newString.append(check[0]);
        char prev = newString.charAt(0);
        int count = 1;
        for (int i = 1; i < check.length; i++) {
            if (check[i] == prev) {
                count++;
            } else {
                newString.append(count);
                if (i <= check.length) {
                    newString.append(check[i]);
                }
                count = 1;
                prev = check[i];
            }
        }

        newString.append(count);

        return newString.toString();
    }
}