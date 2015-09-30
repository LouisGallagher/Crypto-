import java.util.HashMap;

public class FrequencyAnalysis {
    static final String ETAONISRH   = "ETAONISRHetaonisrh";
    static final String ETAON       = "ETAONetaon";
    static final String LNRST       = "LNRSTlnrst";
    static final String VOWELS      = "AEIOUaeiou";
    static final String JKQXZ       = "JKQXZjkqxz";
    
    public static void main (String[] args) {
        // A test.
        String message = new String("aeioukkkkkyyyyy");
        
        System.out.println("Should be ~33%.");
        
        HashMap<Char, Int> freqTable = getCharFrequencyTable(message);
        float pctge = getCharPercentage(VOWELS, freqTable, message.length());
        
    }

    public static float getCharPercentage (String charSequence, HashMap<Char, Int> charFrequencyTable, Int msgLength) {
        /**
         * Takes a list of characters and determines what percentage of times
         * they occur in a message.
         */
        int totalFrequency = 0;
        
        int frequency;
        for (Char c : charSequence.toCharArray()) {
            if (charFrequencyTable.hasKey(c)) {
                frequency = charFrequencyTable.get(c);
                totalFrequency += frequency;
            }
        }
        
        float percentage = ((float)totalFrequency / msgLength) * 100;
        return percentage;
    }
    
    public static HashMap<Char, Int> getCharFrequencyTable (String message) {
        /**
         * Takes a message, maps each character to the number of times it occurs.
         */
        HashMap<Char, Int> charFrequencyTable = new HashMap<Char, Int>();
        
        for (Char c : message.toCharArray) {
            
            if (charFrequencyTable.hasKey(c)) {
                int cFrequency = charFrequencyTable.get(c);
                charFrequencyTable.put(c, cFrequency + 1);
            }
            else {
                charFrequencyTable.put(c, 1);
            }
        }
        
        return charFrequencyTable;
    }
}
