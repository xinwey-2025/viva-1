import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Original Message : ");
        String message = input.nextLine();

        //print character to ascii code
        System.out.println("Encoded Message :");
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);// find the position of the char
            int ascii = ch; //variable char to int : means char to ascii num
            String binary = "";

            while (ascii > 0) {
                int remainder = ascii % 2;
                binary = remainder + binary;
                ascii = ascii / 2;
            }
            while (binary.length() < 8) {
                binary = "0" + binary;
            }

            //String binary = String.format("%8s", Integer.toBinaryString(ascii)).replace(' ', '0');
            //print ascii code to 8 bit binary,need to use String.format, (.replace is to replace the space into '0')

            String flipped = ""; // used to store the flipped binary
            for (char bit : binary.toCharArray()) {
             /*.toCharArray convert the binary string into a character array like{'0','1','0','0','1','0','0','0'}
            So the for loop can go one by one*/
                if (bit == '0') {
                    flipped += '1'; //flipped=flipped+'1'
                } else {
                    flipped += '0';
                }
            }
            int flippedDecimal = 0;
            int power = 1; // represents 2^0

            for (int j = flipped.length() - 1; j >= 0; j--) {
                char bit = flipped.charAt(j);

                if (bit == '1') {
                    flippedDecimal += power; // add the value of that bit
                }

                power *= 2; // move to next power of 2 (1,2,4,8,16,...)
            }

            //int flippedDecimal = Integer.parseInt(flipped, 2);
            // used to convert binary to decimal, (flipped,2)= (binary,base 2)
            System.out.print(flippedDecimal + " ");


        }
    }
}