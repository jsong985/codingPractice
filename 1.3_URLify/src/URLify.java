import java.util.*;

public class URLify {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string: ");
        String input = scan.nextLine();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == ' ') {
                input = input + "  ";
            }
        }
        System.out.println("The URLified string is " + makeURL(input, length));

    }

    private static String makeURL(String input, int length) {

        char[] inputArr = input.toCharArray();

        // Count spaces
        int numSpaces = 0;
        for (int i = 0; i < length; i++) {
            if (inputArr[i] == ' ') {
                numSpaces++;
            }
        }

        // Move characters
        int index = length + 2*numSpaces - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (inputArr[i] == ' ') {
                inputArr[index] = '0';
                inputArr[index - 1] = '2';
                inputArr[index - 2] = '%';
                index = index - 3;
            } else {
                inputArr[index] = inputArr[i];
                index = index - 1;
            }
        }

        return new String(inputArr);

    }

}