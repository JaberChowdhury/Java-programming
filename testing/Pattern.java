import java.util.Arrays;

public class Pattern {

    public static boolean isAnagram(String s1, String s2) {
        // 1. Clean the strings (Remove spaces, make lowercase)
        String str1 = s1.replaceAll("\\s", "").toLowerCase();
        String str2 = s2.replaceAll("\\s", "").toLowerCase();

        boolean x = s1.equals(s2);
        System.out.println(x);
        // 2. Optimization: If lengths differ, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // 3. Convert to Char Array
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // 4. Sort both
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        System.out.println(charArray1);
        // 5. Compare
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("Listen", "Silent")); // true
        System.out.println(isAnagram("Hello", "World")); // false
    }
}
