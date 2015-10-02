public class VigenereCipher {
    public static String encryptString (String plaintext, String key) {
        /** Returns ciphertext of plaintext.
         * Given plaintext & key, encrypts each character in plaintext
         * using corresponding character in key.
         * 
         * It is assumed that:
         * key.length() >= plaintext.length().
         */
        StringBuilder resultBuilder = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i++) {
            char newChar = encryptChar(plaintext.charAt(i), key.charAt(i));
            resultBuilder.append(newChar);
        }
        
        return resultBuilder.toString();
    }
    
    public static String decryptString (String ciphertext, String key) {
        StringBuilder resultBuilder = new StringBuilder();
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char newChar = decryptChar(ciphertext.charAt(i), key.charAt(i));
            resultBuilder.append(newChar);
        }
        
        return resultBuilder.toString();
    }
}
