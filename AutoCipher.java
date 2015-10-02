import java.util.HashMap;
import java.util.ArrayList;
import java.lang.StringBuilder;

import FrequencyAnalysis.*;
import VigenereCipher.decryptChar;

public class AutoCipher {
    public static void main (String[] args) {
        String ciphertext = parseFile(filename);
        HashMap<Integer, Integer> intervalCounts = getIntervalLengthFreq(ciphertext);
        for (Entry<Integer, Integer> entry : intervalCounts.entrySet()) {
            Integer intervalLength = entry.getKey();
            Integer count = entry.getValue();
            System.out.println(intervalLength.toString() + " " + count.toString());
        }
        
        /*
        Derp sortedIntervalCounts = null;
        from highestCount -> lowestCount, possibleKeyWordLength = intervalLength, only try a few:
            String possibleDecryption = tryDecryptingAutoCipher(
                ciphertext, possibleKeyWordLength);
            System.out.println(possibleDecryption);
            System.out.println("\n");
        */
    }
    
    public static String tryDecryptingAutoCipher (String ciphertext, int keyWordLength) {
        ArrayList<String> jumbledDecryption = new ArrayList<String>();
        for (int i = 0; i < keyWordLength; i++) {
            String selectedChars = takeChars(keyWordLength, ciphertext, i);
            String likelyDecryption = getLikelyDecryption(selectedChars);
            jumbledDecryption.add(likelyDecryption);)
        }
    
        StringBuilder plaintext = new StringBuilder();
        
        boolean charsLeft = true;
        int i = 0;
        while (charsLeft) {
            charsLeft = false;
            
            for (String selectedCharsDecrypted : jumbledDecryption) {
                if (i < selectedCharsDecrypted.length()) {
                    charsLeft = true;
                    plaintext.append(selectedCharsDecrypted.charAt(i));
                }
            }
        }
        
        return plaintext.toString();
    }
    
    public static HashMap<Integer, Integer> getIntervalLengthFreq (String message) {
        /** Returns a HashMap that maps interval length -> frequency.
         * 
         * Interval length is the distance between equal characters
         * in the message.
         * 
         * e.g. "abbaa"
         * There is one interval of length 3 (a to a), and two intervals
         * of length 1 (a to a, b to b).
         * So the method would return a map where:
         *      3 -> 1,
         *      1 -> 2
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
    
    public static String getLikelyDecryption (String sequence) {
        /**
         * Similar scenario to decryptSequence(), except this tries all the
         * possible first keyWordChars and picks the best one using frequency
         * analysis.
         */
        String mostLikeEnglish;
        // Smaller means closer match to English, in terms of letter frequency.
        double smallestEnglishDifference = Double.POSITIVE_INFINITY;
        
        String decrypted;
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
