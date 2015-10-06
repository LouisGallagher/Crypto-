package crypto;

import java.util.HashMap;
import java.util.Dictionary;
import java.util.Hashtable;

public class Utils {
    public static int positiveMod (int x, int n) {
        int result = x % n;
        if (result < 0) {
            result += n;
        }
        
        return result;
    }
    
    public static char getCharValue (char c) {
        /** Maps    A,a -> 0,
         *          B,b -> 1,
         *          ...
         *          Z,z -> 25
         * Should probably be able to work with different alphabets.
         */
        char base;
        if (Character.isUpperCase(c)) {
            base = 'A';
        }
        else {
            base = 'a';
        }
        
        return (char)(c % base);
    }
}
