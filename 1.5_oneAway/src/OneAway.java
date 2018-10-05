import java.util.*;

public class OneAway {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String input1 = scan.nextLine();
        System.out.println("Enter the second string: ");
        String input2 = scan.nextLine();
        System.out.println("One apart: " + isOneAway(input1, input2));

    }

    private static boolean isOneAway(String input1, String input2) {

        int length1 = input1.length();
        int length2 = input2.length();

        if (length1 == length2) {
            return isOneAwayReplace(input1, input2);
        } else if (length2 - length1 == 1) {
            return isOneAwayInsert(input1, input2);
        } else if (length1 - length2 == 1) {
            return isOneAwayInsert(input2, input1);
        }
        return false;

    }

    private static boolean isOneAwayReplace(String input1, String input2) {

        boolean differenceFound = false;
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) != input2.charAt(i)) {
                if (differenceFound) {
                    return false;
                } else {
                    differenceFound = true;
                }
            }
        }
        return true;

    }

    private static boolean isOneAwayInsert(String input1, String input2) {

        for (int idx1 = 0, idx2 = 0; idx1 < input1.length(); idx1++, idx2++) {
            if (input1.charAt(idx1) != input2.charAt(idx2)) {
                if (idx1 != idx2) {
                    return false;
                } else {
                    idx2++;
                }
            }
        }
        return true;

    }

}
