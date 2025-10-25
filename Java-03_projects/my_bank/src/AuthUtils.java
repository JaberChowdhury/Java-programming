public class AuthUtils {

    public static String encode(String raw_password) {
        String encoded = "";

        for (int i = 0; i < raw_password.length(); i++) {
            char x = raw_password.charAt(i);
            int y = x;
            y += 10;
            char z = (char) y;
            encoded += z;
            if (i != raw_password.length() - 1) {
                encoded += "-|-";
            }
        }
        return encoded;
    }

    public static String decode(String encoded_password) {
        String decoded = "";

        String[] parts = encoded_password.split("-\\|-");

        for (String part : parts) {
            char z = part.charAt(0);

            int y = z;

            y -= 10;

            char x = (char) y;

            decoded += x;
        }

        return decoded;
    }
}
