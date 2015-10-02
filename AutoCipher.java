import java.util.HashMap;
import java.lang.StringBuilder;

import FrequencyAnalysis.*;
import VigenereCipher.decryptChar;

public class AutoCipher {
    public static void main (String[] args) {
        // call solution here.
    }
    
    public static String crackAutoCipher (String filename) {
        /** Given only the ciphertext, attempts to break an Auto Cipher. */
        
        String ciphertext = parseFile(filename);
        
        HashMap<Integer, Integer> intervalCounts = getIntervalLengthFreq(ciphertext);
        // -> sort intervalCounts by the values, i.e. the frequencies?
        // pick one?
        
        // 4) use takeChars() for (int i = 0; i < intervalLength; i++)
        //      to get a list of decrypted takeChars() results.
        // 5) join the list together. 1st character from 1st, 2nd, ... string,
        // 2nd character from 1st, 2nd, ... string, etc.
        
        return "temp";
    }
    
    public static HashMap<Integer, Integer> getIntervalLengthFreq (String message) {
        /** Returns a HashMap that maps interval length -> frequency.
         * 
         * Interval length is the distance between equal characters
         * in the message.
         * 
         * e.g. "abba"
         * There is one interval of length 3 (a to a), and one interval
         * of length 1 (b to b).
         */
        HashMap<Character, Integer> charIndex = new HashMap<Character, Integer>();
        HashMap<Integer, Integer> intervalCount = new HashMap<Integer, Integer>();
        
        int intervalLength;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            
            if (charIndex.containsKey(c)) {
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
    
    public static String takeChars (int n, String message, int start) {
        /** Takes characters from "message" in jumps of "n", beginning at "start". */
        StringBuilder sbuilder = new StringBuilder();
        
        for (int i = start; i < message.length(); i += n) {
            sbuilder.append(message.charAt(i));
        }
        
        return sbuilder.toString();
    }
    
    public static String tryKeyChars (String sequence) {
        /**
         * Similar scenario to decryptSequence(), except this tries all the
         * possible first keyWordChars and picks the best one using frequency
         * analysis.
         */
        String mostLikeEnglish;
        // Smaller means closer match to English, in terms of letter frequency.
        double smallestEnglishDifference = Double.POSITIVE_INFINITY;
        
        String decryptAttempt;
        double englishDifference;
        for (char keyWordChar = 'a'; keyWordChar <= 'z'; keyWordChar++) {
            decrypted = decryptSequence(sequence, keyWordChar);
            englishDifference = getEnglishDifference(decrypted);
            
            if (englishDifference < smallestEnglishDifference) {
                smallestEnglishDifference = englishDifference;
                mostLikeEnglish = decrypted;
            }
        }
        
        return mostLikeEnglish;
    }
    
    public static String decryptSequence (String sequence, char keyWordChar) {
        /**
         * Takes a list of characters, assuming that they are all separated
         * by the same distance (the guessed key word length) in the original
         * ciphertext, and decrypts them.
         * 
         * e.g. given abc, say it was guessed that keyWord.length() = 3, then 
         * the ciphertext would look like:
         * aXXbXXc, XaXXbXXcX or XXaXXbXXc.
         * So each of these characters is used to encrypt the next one. Except 'a',
         * which was encrypted using a character from the key word ("keyWordChar").
         */
        StringBuilder resultBuilder = new StringBuilder();
        
        char key = keyWordChar;
        for (int i = 0; i < sequence.length(); i++) {
            char decryptedChar = decryptChar(sequence.charAt(i), key);
            resultBuilder.append(decryptedChar);
            key = decryptedChar;
        }
        
        return resultBuilder.toString();
    }
}
