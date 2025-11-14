import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ic;

        /* input - ic validation */
        while (true) {
            System.out.print("Enter IC number (YYMMDD-##-####): ");
            ic = input.nextLine();
            if (ic.length() == 14) {
                break;
            }
            System.out.println("Invalid IC number. Please try again...");
        }

        /* determine birth date */
        // extract individual digits
        int y1 = ic.charAt(0) - '0';
        int y2 = ic.charAt(1) - '0';
        int m1 = ic.charAt(2) - '0';
        int m2 = ic.charAt(3) - '0';
        int d1 = ic.charAt(4) - '0';
        int d2 = ic.charAt(5) - '0';

        // convert to decimal value
        int yy = (y1 * 10) + y2;
        int month = (m1 * 10) + m2;
        int day = (d1 * 10) + d2;

        int year;
        if (yy >= 0 && yy <= 25) {
            year = 2000 + yy;
        } else {
            year = 1900 + yy;
        }

        /* determine gender */
        int g = ic.charAt(ic.length() - 1) - '0';  // retrieve last digit
        String gender;
        if (g % 2 != 0) {
            gender = "Male";    // odd
        } else {
            gender = "Female";  // even
        }

        /* determine days in month (long or short month) */
        int dayMonth;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                dayMonth = 31;
                break;
            case 2:
                dayMonth = 28;
                break;
            default:
                dayMonth = 30;
                break;
        }

        // print sum of digit
        int sum = 0;
        int digit;

        for (int i = 0; i < ic.length(); i++) {
            char ch = ic.charAt(i);

            if (ch != '-') {  // ignore dashes
                digit = ch - '0'; // convert to int
                sum += digit;
            }
        }

        /* determine if winner - follow game rules */
        boolean isWinner = false;
        if (gender.equals("Male")) {
            if (sum % 5 == 0 && (dayMonth == 28 || dayMonth == 30)) {
                isWinner = true;
            }
        } else {
            if (sum % 7 == 0 && (dayMonth == 31)) {
                isWinner = true;
            }
        }

        /* print results */
        System.out.println("Birth Date: " + day + "/" + month + "/" + year);
        System.out.println("Gender: " + gender);
        System.out.println("Sum of Digits: " + sum);
        if (isWinner) {
            System.out.println("Lucky Winner: Yes");
        } else {
            System.out.println("Lucky Winner: No");
        }
    }
}
