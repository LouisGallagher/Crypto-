import java.util.HashMap;

public class FrequencyAnalysis {
    // Groups of letters and a rough percentage of their frequency in
    // the English language.
    static final String ETAONISRH           = "ETAONISRHetaonisrh";
    static final double ETAONISRHpercentage = 70.0;
    
    static final String ETAON               = "ETAONetaon";
    static final double ETAONpercentage     = 45.0;
    
    static final String LNRST               = "LNRSTlnrst";
    static final double LNRSTpercentage     = 33.0;
    
    static final String VOWELS              = "AEIOUaeiou";
    static final double VOWELSpercentage    = 38.0;
    
    static final String JKQXZ               = "JKQXZjkqxz";
    static final double JKQXZpercentage     = 1.0;
    
    public static void main (String[] args) {
        // A test.
        String message = new String("aeioukkkkkyyyyy");
        
        System.out.println("Should be ~33%.");
        
        HashMap<Character, Integer> freqTable = getCharFrequencyTable(message);
        double pctge = getCharPercentage(VOWELS, freqTable, message.length());
        System.out.println(pctge);
    }

    public static double getCharPercentage (String charSequence, 
            HashMap<Character, Integer> charFrequencyTable, int msgLength) {
        /**
         * Takes a list of characters and determines what percentage of times
         * they occur in a message.
         */
        int totalFrequency = 0;
        
        int frequency;
        for (char c : charSequence.toCharArray()) {
            if (charFrequencyTable.containsKey(c)) {
                frequency = charFrequencyTable.get(c);
                totalFrequency += frequency;
            }
        }
        
        double percentage = ((double)totalFrequency / msgLength) * 100;
        return percentage;
    }
    
    public static HashMap<Character, Integer> getCharFrequencyTable (
            String message) {
        /**
         * Takes a message, maps each character to the number of times it occurs.
         */
        HashMap<Character, Integer> charFrequencyTable = new HashMap<
            Character, Integer>();
        
        for (char c : message.toCharArray()) {
            
            if (charFrequencyTable.containsKey(c)) {
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
