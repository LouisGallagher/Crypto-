package crypto;

import java.lang.StringBuilder;

public class AffineCipher {
    
    
    public static char digraphEncrypt (char x, char y, int keyA, int keyB, int n) {
        /** Params: x & y - char pair to be encrypted.
         *          n2    - size of the alphabet, SQUARED.
         */
        char p = x * n + y;
        char encrypted = (char)((keyA * p + keyB) % (n * n));
        return encrypted;
    }
    
    public static char[] digraphDecrypt (char cipherChar, int keyAinverse, int keyB, int n) {
        /** Returns pair (x & y) in slots 0 and 1 of a character array. */
        char p = (char)Utils.positiveMod(keyAinverse * (cipherChar - keyB), n * n);
        char y = (char)(p % n);
        char x = (char)((p - y) / n);
        return new char[]{x, y};
    }
    
    public static String crackAffine (String ciphertext, int n) {
        // n - alphabet size.
        String possiblePlaintext = "";
        Double bestEnglishScore = Double.POSITIVE_INFINITY;
        for (int i = 0; i  < ciphertext.length(); i++) {
            
        }
    }
    
    public static String encryptString (String plaintext, int keyA, int keyB, int n) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i++) {
            char cipherChar = affineEncrypt(plaintext.charAt(i), keyA, keyB, n);
            result.append(cipherChar);
        }
        
        return result.toString();
    }
    
    public static String decryptString (String ciphertext, int keyA, int keyB, int n) {
        StringBuilder result = new StringBuilder();
        
        int keyAinverse = Utils.getInverse(keyA);
        for (int i = 0; i < ciphertext.length(); i++) {
            char plainChar = affineDecrypt(ciphertext.charAt(i), keyAinverse, keyB, n);
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
