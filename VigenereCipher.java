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
    
    public static char encryptChar (char c, char key) {
        int cValue = getCharValue(c);
        int keyValue = getCharValue(key);
        
        int newValue = (cValue + keyValue) % 26;
        
        char newChar = 'a' + (char)newValue;
        
        return newChar;
    }
    
    public static char decryptChar (char c, char key) {
        int cValue = getCharValue(c);
        int keyValue = getCharValue(key);
        
        int newValue = positiveMod(cValue - keyValue, 26);
        
        char newChar = 'a' + (char)newValue;
        
        return newChar;
    }
    
    public static int getCharValue (char c) {
        /** Maps    A,a -> 0,
         *          B,b -> 1,
         *          ...
         *          Z,z -> 25
         */
        char base;
        if (Character.isUpperCase(c)) {
            base = 'A';
        }
        else {
            base = 'a';
        }
        
        return (int)(c % base);
    }
    
    public static positiveMod (int n, int m) {
        /** (n % m) -> positive.
         * The % operation can give negative answers.
         * This provides a positive answer, so -1 % 2 = 1 instead of -1.
         * 
         * (This should probably be in a different file).
         */
        int result = n % m;
        return (n < 0 ? result + m : result);
    }
}
