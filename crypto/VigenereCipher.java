package crypto;

import java.lang.StringBuilder;

public class VigenereCipher {
    public static void main (String[] args) {
        System.out.println(decryptChar('a', 'b'));
    }

    public static String vigenereEncrypt (String plaintext, String keyWord) {
        StringBuilder keyBuilder = new StringBuilder(keyWord);
        while (keyBuilder.length() < plaintext.length()) {
            keyBuilder.append(keyWord);
        }
        
        String key = keyBuilder.toString();
        String ciphertext = encryptString(plaintext, key);
        
        return ciphertext;
    }

    public static String encryptString (String plaintext, String key) {
        /** Returns ciphertext of plaintext.
         * Given plaintext & key, encrypts each character in plaintext
         * using corresponding character in key.
         * 
         * It is assumed that:
         * key.length() >= plaintext.length().
         */
        return changeString(plaintext, key, true);
    }
    
    public static String decryptString (String ciphertext, String key) {
        return changeString(ciphertext, key, false);
    }
    
    public static String changeString (String ciphertext, String key,
            boolean encrypt) {
        StringBuilder resultBuilder = new StringBuilder();
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char newChar;
            if (encrypt) {
                newChar = encryptChar(ciphertext.charAt(i), key.charAt(i));
            }
            else {
                newChar = decryptChar(ciphertext.charAt(i), key.charAt(i));
            }
            
            resultBuilder.append(newChar);
        }
        
        return resultBuilder.toString();
    }
    
    public static char encryptChar (char c, char key) {
        return changeChar(c, key, true);
    }
    
    public static char decryptChar (char c, char key) {
        return changeChar(c, key, false);
    }
    
    public static char changeChar (char c, char key, boolean encrypt) {
        char cValue = Utils.getCharValue(c);
        char keyValue = Utils.getCharValue(key);
        
        char newValue;
        if (encrypt) {
            newValue = (char)((cValue + keyValue) % 26);
        }
        else {
            // Workaround for 2 annoying things:
            //      1) Implicit cast conversion of char -> int.
            //      2) Java returning negative answers from %.
            int temp = (cValue - keyValue) % 26;
            if (temp < 0) {
                temp += 26;
            }
            newValue = (char)temp;
        }
        
        char newChar = (char)('a' + newValue);
        
        return newChar;
    }
}
