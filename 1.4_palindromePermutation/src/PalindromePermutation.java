import java.util.*;

public class PalindromePermutation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scan.nextLine();
        System.out.println("It is " + palindromePermutation(input) + " that this is a permutation of a palindrome.");
    }

    private static boolean palindromePermutation(String input) {

        int strLen = input.length();
        int[] isOdd = new int[26];
        for (int i = 0; i < strLen; i++) {
            int idx = charIndex(input.charAt(i));
            if (idx != -1) {
                isOdd = toggle(isOdd, idx);
            }
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum = sum + isOdd[i];
            if (sum > 1) {
                return false;
            }
        }
        return true;

    }

    private static int charIndex(char c) {

        int cVal = Character.getNumericValue(c);
        int aVal = Character.getNumericValue('a');
        int zVal = Character.getNumericValue('z');

        if (cVal >= aVal && cVal <= zVal) {
            return cVal - aVal;
        } else {
            return -1;
        }

    }

    private static int[] toggle(int[] arr, int idx) {

        if (arr[idx] == 0) {
            arr[idx] = 1;
        } else {
            arr[idx] = 0;
        }
        return arr;

    }

}
