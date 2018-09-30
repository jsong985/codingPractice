import java.util.*;

public class IsUnique {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scan.nextLine();
        System.out.println(allUniqueChars(input));

    }

    private static boolean allUniqueChars(String input) {

        HashMap<Character, Boolean> uniqueChars = new HashMap<>();

        // Iterate over string and check for duplicates
        for (int i = 0; i < input.length(); i++) {
            Boolean isUnique = uniqueChars.get(input.charAt(i));
            if (isUnique != null) {
                return false;
            } else {
                uniqueChars.put(input.charAt(i), true);
            }
        }

        return true;

    }

}