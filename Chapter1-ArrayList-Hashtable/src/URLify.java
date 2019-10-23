/**
 * URLify
 */
public class URLify {

    public static void main(String[] args) {
        System.out.println(urlString("Mr John Smith       "));
    }

    public static String urlString(String string) {
        StringBuilder newString = new StringBuilder();
        for (char c : string.trim().toCharArray()) {
            if (c == ' ') {
                newString.append("%20");
            } else {
                newString.append(c);
            }
        }

        return newString.toString();
    }
}