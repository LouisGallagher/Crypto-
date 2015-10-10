package crypto;

import java.util.HashMap;
import java.util.ArrayList;

public class Utils {
    public static void main (String[] args) {
        System.out.println(getInverse(3, 11));
    }
    
    public static int getInverse (int a, int n) {
        // Returns (x^-1) mod n, having assumed that x is coprime to n.
        // Based directly on pseudocode from Wikipedia.
        int t = 0, newt = 1;
        int r = n, newr = a;
        
        while (newr != 0) {
            int quotient = r / newr;
            
            int tempt = t;
            t = newt;
            newt = tempt - quotient * newt;
            
            int tempr = r;
            r = newr;
            newr = r - quotient * newr;
        }
        
        if (r > 1) {
            return -1;
        }
        
        if (t < 0) {
            t = t + n;
        }
        
        return t;
    }
    
    public static int[] getCoprimes (int n) {
        // Returns all numbers <n that are coprime to it.
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        
        boolean[] sieve = new boolean[n];
        for (int m = 2; m < n; m++) {
            if (n % m == 0) {
                for (int j = m + m; j < n; j += m) {
                    // "true" can be taken to mean "there is a
                    // divisor of n and this".
                    sieve[j] = true;
                }
            }
            else if (!sieve[m]) {
                result.add(m);
            }
        }
        
        return result.toArray();
    }
    
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
         * Should probably accept an integer.
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
