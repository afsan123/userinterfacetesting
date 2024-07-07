package utility;

import java.util.Random;

public class RandomPasswordGenerator {
    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERALS = "0123456789";
    private static final String CYRILLIC_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static String generateRandomPassword(String email) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Add at least 1 capital letter
        password.append(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));

        // Add at least 1 numeral
        password.append(NUMERALS.charAt(random.nextInt(NUMERALS.length())));

        // Add at least 1 letter from the email
        char emailChar = email.charAt(random.nextInt(email.length()));
        password.append(Character.toLowerCase(emailChar));

        // Generate remaining characters (at least 7 more characters)
        for (int i = 0; i < 7; i++) {
            int choice = random.nextInt(3); // 0: lowercase letter, 1: cyrillic character, 2: numeral
            switch (choice) {
                case 0 -> password.append(Character.toLowerCase(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length()))));
                case 1 -> password.append(CYRILLIC_CHARACTERS.charAt(random.nextInt(CYRILLIC_CHARACTERS.length())));
                case 2 -> password.append(NUMERALS.charAt(random.nextInt(NUMERALS.length())));
            }
        }
        // Shuffle the characters randomly
        for (int i = 0; i < password.length(); i++) {
            int index = random.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(index));
            password.setCharAt(index, temp);
        }
        return password.toString();
    }
}
