import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner aSCANNER = new Scanner(System.in);
        String plainText;
        int shiftKey;

        System.out.println("Please enter message to be encrypted: ");
        plainText = aSCANNER.nextLine();

        System.out.println("Please enter Shift Key: ");
        shiftKey = aSCANNER.nextInt();
        String encryptedText = EncryptText(plainText, shiftKey);


        System.out.println("The Encrypted Text: " + encryptedText);
        System.out.println("The Decrypted Text: " + DecryptText(encryptedText, shiftKey));
    }

    public static String EncryptText(String message, int shiftKey) {
        final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
        message = message.toLowerCase();

        StringBuilder cypherText = new StringBuilder();

        for (int counter = 0; counter < message.length(); counter++) {
            if (!Character.isLetter(message.charAt(counter))) {
                cypherText.append(message.charAt(counter));
            } else {
                int charPosition = ALPHABETS.indexOf(message.charAt(counter));
                int keyValue = (charPosition + shiftKey) % 26;

                char cypherValue = ALPHABETS.charAt(keyValue);

                cypherText.append(cypherValue);
            }
        }
        return cypherText.toString();
    }

    public static String DecryptText(String message, int shiftKey) {
        final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
        message = message.toLowerCase();

        StringBuilder plainText = new StringBuilder();

        for (int counter = 0; counter < message.length(); counter++) {
            if (!Character.isLetter(message.charAt(counter))) {
                plainText.append(message.charAt(counter));
            } else {
                int charPosition = ALPHABETS.indexOf(message.charAt(counter));
                int keyValue = (charPosition - shiftKey) % 26;

                if (keyValue < 0) {

                    keyValue = ALPHABETS.length() + keyValue;
                }

                char plainValue = ALPHABETS.charAt(keyValue);

                plainText.append(plainValue);
            }
        }
        return plainText.toString();
    }
}

