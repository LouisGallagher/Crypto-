package crypto;

import java.util.HashMap;
import java.util.Map.Entry;
import java.lang.Math;

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
    
    static HashMap<String, Double> EXPECTEDFREQ = new HashMap<
        String, Double>();
    
    static {
        EXPECTEDFREQ.put(ETAONISRH, ETAONISRHpercentage);
        EXPECTEDFREQ.put(ETAON,     ETAONpercentage);
        EXPECTEDFREQ.put(LNRST,     LNRSTpercentage);
        EXPECTEDFREQ.put(VOWELS,    VOWELSpercentage);
        EXPECTEDFREQ.put(JKQXZ,     JKQXZpercentage);
    }
    
    public static void main (String[] args) {
        // A test.
        String message = new String("aeioukkkkkyyyyy");
        
        System.out.println("Should be ~33%.");
        
        HashMap<Character, Integer> freqTable = getCharFrequencyTable(
            message);
        double pctge = getCharPercentage(VOWELS, freqTable, message.length());
        System.out.println(pctge);
    }
    
    public static double getEnglishDifference (String message) {
        /**
         * Given a message, gets the % occurrence of various groups of
         * characters within that message, and returns the difference
         * between actual and expected %. Longer message = more accuracy.
         * 
         * e.g. given message="aeiou", goes through VOWELS constant and finds
         * that 100.0% of the characters in message are in VOWELS. So:
         *  total += | 100.0 - VOWELSpercentage |
         * 
         * The lower the value returned, the closer the text is to English.
         */
        double total = 0.0;
        
        HashMap<Character, Integer> charFreqTable = getCharFrequencyTable(
            message);
        for (Entry<String, Double> entry : EXPECTEDFREQ.entrySet()) {
            double expectedPerc = entry.getValue();
            String charGroup = entry.getKey();
            
            double perc = getCharPercentage(charGroup, charFreqTable,
                message.length());
            total += Math.abs(expectedPerc - perc);
        }
        
        return total;
    }

    public static double getCharPercentage (String charSequence, 
            HashMap<Character, Integer> charFrequencyTable, int msgLength) {
        /**
         * Takes a list of characters and determines what percentage of times
         * they occur in a message.
         */
        int totalFrequency = 0;
        
        for (char c : charSequence.toCharArray()) {
            if (charFrequencyTable.containsKey(c)) {
                int frequency = charFrequencyTable.get(c);
                totalFrequency += frequency;
            }
        }
        
        double percentage = ((double)totalFrequency / msgLength) * 100;
        return percentage;
    }
    
    public static HashMap<Character, Integer> getCharFrequencyTable (
            String message) {
        /**
         * Takes a message, maps each character to the
         * number of times it occurs.
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
