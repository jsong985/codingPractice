import java.util.*;

public class CheckPermutation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String input1 = scan.nextLine();
        System.out.println("Enter the second string: ");
        String input2 = scan.nextLine();
        System.out.println("Sorted string option returns " + checkPermutationA(input1, input2));
        System.out.println("Hash table option returns " + checkPermutationB(input1, input2));

    }

    // Checks for permutation by sorting strings
    private static boolean checkPermutationA(String input1, String input2) {

        // Different-length strings cannot be permutations
        if (input1.length() != input2.length()) {
            return false;
        }

        // Sort strings
        String sortedInput1 = sortString(input1);
        String sortedInput2 = sortString(input2);

        return sortedInput1.equals(sortedInput2);

    }

    // Checks for permutation by hashing strings
    private static boolean checkPermutationB(String input1, String input2) {

        // Different-length strings cannot be permutations
        if (input1.length() != input2.length()) {
            return false;
        }

        HashMap<Character, Integer> charCounts = new HashMap<>();

        // Hash first string
        for (int i = 0; i < input1.length(); i++) {
            Character currChar = input1.charAt(i);
            Integer charCount = charCounts.get(currChar);
            if (charCount == null) {
                charCounts.put(currChar, 1);
            } else {
                charCounts.put(currChar, charCount + 1);
            }
        }

        // Check second string against hash table
        for (int i = 0; i < input2.length(); i++) {
            Character currChar = input2.charAt(i);
            Integer charCount = charCounts.get(currChar);
            if (charCount == null) {
                return false;
            } else if (charCount == 1) {
                charCounts.remove(currChar);
            } else {
                charCounts.put(currChar, charCount - 1);
            }
        }

        return true;

    }
    
    private static String sortString(String input) {
        
        char[] inputChars = input.toCharArray();
        Arrays.sort(inputChars);
        return new String(inputChars);

    }

}
