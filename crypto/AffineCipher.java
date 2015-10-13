package crypto;

import java.lang.StringBuilder;

public class AffineCipher {
    public static String encryptString (String plaintext, int keyA, int keyB, int n) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i++) {
            char cipherChar = affineEncrypt(plaintext.charAt(i));
            result.append(cipherChar);
        }
        
        return result.toString();
    }
    
    public static String decryptString (String ciphertext, int keyA, int keyB, int n) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char plainChar = affineDecrypt(ciphertext.charAt(i));
            result.append(plainChar);
        }
        
        return result.toString();
    }
    
    public static char affineEncrypt (char c, int keyA, int keyB, int n) {
        /**
         * Parameters:
         *      c           - numeric value <n representing a character.
         *      keyA & keyB - the keys.
         *      n           - the alphabet size.
         */
        return (char)(((keyA * c) + keyB) % n);
    }
    
    public static char affineDecrypt (char c, int keyAinverse, int keyB, int n) {
        /**
         * Parameters:
         *      Same as above, but keyAinverse = (a^-1) mod n
         */
        return Utils.positiveMod(keyAinverse * (c - b), n);
    }
}
