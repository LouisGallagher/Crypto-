import java.util.HashMap;

public class AutoCipher {
    public static HashMap<Integer, Integer> getIntervalCounts (String message) {
        /** Returns a HashMap that maps interval length -> count.
         * Interval length is the distance between equal characters
         * in the message.
         * Count is how often this length is seen.
         * This is a bad explanation.
         */
        HashMap<Character, Integer> charIndex = new HashMap<Character, Integer>();
        HashMap<Integer, Integer> intervalCount = new HashMap<Integer, Integer>();
        
        int intervalLength;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            
            if (charIndex.containsKey(c) {
                intervalLength = i - charIndex.get(c);
                
                if (intervalCount.containsKey(intervalLength)) {
                    int count = intervalCount.get(intervalLength);
                    intervalCount.put(intervalLength, count + 1);
                }
                else {
                    intervalCount.put(intervalLength, 1);
                }
            }
            
            charIndex.put(c, i);
        }
        
        return intervalCount;
    }
}
