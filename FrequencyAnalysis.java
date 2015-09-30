import java.util.HashMap;

public class FrequencyAnalysis {
    static final String ETAONISRH   = "ETAONISRHetaonisrh";
    static final String ETAON       = "ETAONetaon";
    static final String LNRST       = "LNRSTlnrst";
    static final String VOWELS      = "AEIOUaeiou";
    static final String JKQXZ       = "JKQXZjkqxz";
    

    public static float getCharPercentage (String charSequence, HashMap<Char, Int> charFrequencyTable, Int msgLength) {
        /**
         * Takes a list of characters and determines what percentage of times
         * they occur in a message.
         */
        int totalFrequency = 0;
        
        int frequency;
        for (Char c : charSequence) {
            frequency = charFrequencyTable.get(c);
            if (frequency != null) {
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
        
        for (Char c : message) {
            int cFrequency = charFrequencyTable.get(c);
            if (cFrequency == null) {
                charFrequencyTable.put(c, 1);
            }
            else {
                charFrequencyTable.put(c, cFrequency + 1);
            }
        }
        
        return charFrequencyTable;
    }
}
