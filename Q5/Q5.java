import java.util.Scanner;

public class Q5Alt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Original Message: ");
        String message = input.nextLine();
        System.out.println("Encoded Message");

        int c;
        String binaryString;
        int encoded;

        for (int i = 0; i < message.length(); i++) {
            // process one character at a time
            // c holds the ASCII decimal value of this character
            c = message.charAt(i);

            // invert current character using bitwise NOT operator
            c = ~c;

            // convert to binary representation string
            binaryString = Integer.toBinaryString(c);

            // since converted string is 32 bits long (length of int)
            // only extract the last 8 bits for use
            binaryString = binaryString.substring(32 - 8);

            // convert back to decimal
            encoded = Integer.parseInt(binaryString, 2);

            // decoding ends; print decoded string
            System.out.print(encoded + " ");
        }

        System.out.println();
    }
}
