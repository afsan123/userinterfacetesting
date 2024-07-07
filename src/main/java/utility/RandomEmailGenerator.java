package utility;

import java.util.Random;

public class RandomEmailGenerator {
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzДЕЖЙКЛМНОБПФЧЦЩABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String EMAIL_DOMAIN = "@example.com";

    public static String generateRandomEmail() {
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Add a random username (length between 5 and 10 characters)
        int usernameLength = random.nextInt(6) + 5;
        for (int i = 0; i < usernameLength; i++) {
            int index = random.nextInt(ALLOWED_CHARACTERS.length());
            email.append(ALLOWED_CHARACTERS.charAt(index));
        }

        // Add the domain to complete the email
        email.append(EMAIL_DOMAIN);

        return email.toString();
    }
}
