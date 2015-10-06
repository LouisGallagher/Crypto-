package crypto;

public class AffineCipher {
    public static int affineEncrypt (int c, int keyA, int keyB, int n) {
        /**
         * Parameters:
         *      c           - numeric value <n representing a character.
         *      keyA & keyB - the keys.
         *      n           - the alphabet size.
         */
        return ((keyA * c) + keyB) % n;
    }
    
    public static int affineDecrypt (int c, int keyAinverse, int keyB, int n) {
        /**
         * Parameters:
         *      Same as above, but keyAinverse = (a^-1) mod n
         */
        return Utils.positiveMod(keyAinverse * (c - b), n);
    }
}
