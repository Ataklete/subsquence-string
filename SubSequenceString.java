import java.util.*;

public class SubSequenceString {

    public static void main(String[] args) {
        String str = "abcde";
        String[] subStr = {"a", "bb", "acd", "ace"};
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq(s, words));
    }


        public static int numMatchingSubseq(String s, String[] words) {
            Map<Character, Queue<Integer>> charIndices = new HashMap<>();

            // Preprocess: map each character to its indices in s
            for (int i = 0; i < s.length(); i++) {
                charIndices.computeIfAbsent(s.charAt(i), initializeWith -> new LinkedList<>()).add(i);
            }
            System.out.println(charIndices);
            int count = 0;
            for (String word : words) {
                if (isSubsequence(word, charIndices)) {
                    count++;
                }
            }

            return count;
        }

        private static boolean isSubsequence(String word, Map<Character, Queue<Integer>> charIndices) {
            int prevIndex = -1;

            for (char c : word.toCharArray()) {
                if (!charIndices.containsKey(c)) return false;

                // Binary search for the next index greater than prevIndex
                boolean found = false;
                for (int index : charIndices.get(c)) {
                    if (index > prevIndex) {
                        prevIndex = index;
                        found = true;
                        break;
                    }
                }

                if (!found) return false;
            }

            return true;
        }
    }
