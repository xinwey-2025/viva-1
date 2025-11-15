import java.lang.String;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0f;  // total price amount
        double price;       // current price input
        String day;         // day in text - Sunday, Monday etc
        int hour;           // time hour in 24-hour format
        char response;    // response for the question below - y or n
        boolean isMember;   // is this customer a member?


        /* input - get item prices */
        while (true) {
            System.out.print("Enter item price (0 to finish): ");
            price = input.nextDouble();
            if (price == 0) {  // end input
                if (total == 0)  // no items added
                    System.out.println("Please enter at least one item.");
                else  // total is not zero - at least one item added
                    break;
            }
            else if (price < 0) {  // invalid - negative amount
                System.out.println("Invalid amount. Price cannot be negative. Please re-enter.");
                continue;
            }
            total += price;  // passed checks - add to total amount
        }

        input.nextLine();  // flush/discard leftover \n from previous input

        /* input - get day of week */
        while (true) {
            System.out.print("Enter day of week: ");
            day = input.nextLine().toLowerCase().substring(0, 3);
            /* line above does a few things:
             * - reads a line from keyboard
             * - converts string to lowercase - allow case-insensitive matching
             * - extract and use the first three characters only - mon, tue, wed, thu, fri, sat, sun
             * overall easier for the user to input! case doesn't matter and can accept shortcuts
             */

            if (day.equals("sun") ||
                day.equals("mon") ||
                day.equals("tue") ||
                day.equals("wed") ||
                day.equals("thu") ||
                day.equals("fri") ||
                day.equals("sat")) {
                break;
            }

            System.out.println("Invalid day. Please re-enter.");
        }

        /* input - get hour of time */
        while (true) {
            System.out.print("Enter hour (24-hour format): ");
            hour = input.nextInt();
            if (hour >= 0 && hour <= 24) {  // check if hour is in range[0, 24]
                break;
            }
            System.out.println("Invalid hour. Please re-enter.");
        }

        input.nextLine();  // flush/discard leftover \n from previous input

        /* input - ask if customer is member? */
        while (true) {
            System.out.print("Is customer a member (Y/N)? ");
            // read a line, extract only the first character, make it case-insensitive
            response =  input.nextLine().toLowerCase().charAt(0);
            if (response == 'y' || response == 'n') {
                break;
            }
            System.out.println("Invalid input. Please re-enter.");
        }
        isMember = response == 'y';  // if y then isMember equals true, false if otherwise


        /* end of input, print total amount */
        System.out.println("\n-------- Kopi-Satu Receipt --------");
        System.out.printf("Subtotal:                  RM %-4.2f\n", total);

        /* calculate service tax (SST) */
        if (total <= 30) {
            System.out.printf("Service tax (6%%):          RM %-4.2f\n", total * 0.06);
            total *= 1.06;  // 6% tax for x <= RM30
        }
        else if (total <= 100) {
            System.out.printf("Service tax (8%%):          RM %-4.2f\n", total * 0.08);
            total *= 1.08;  // 8% tax for RM30 < x <= RM100
        }
        else {
            System.out.printf("Service tax (10%%):         RM %-4.2f\n", total * 0.1);
            total *= 1.10;  // 10% tax for x > RM100
        }

        System.out.printf("Total before discount:     RM %-4.2f\n", total);

        /* discounts */
        if (day.equals("sat") || day.equals("sun")) {  // weekends
            if (total >= 50) {
                System.out.printf("Weekend Discount (5%%):     RM %-4.2f\n", total * 0.05);
                total *= 0.95;  // apply "Weekend Combo Discount" -5%
            }
        }
        else {  // weekdays
            if (total > 25) {
                System.out.printf("Student Discount (10%%):    RM %-4.2f\n", total * 0.1);
                total *= 0.9;  // apply "Student Saver Discount" -10%
            }
            if (hour >= 15 && hour < 17) {
                System.out.printf("Happy Hour Discount (5%%)   RM %-4.2f\n", total * 0.05);
                total *= 0.95; // apply "Happy Hour Discount" -5%
            }
        }

        System.out.println("-----------------------------------");  // divider
        System.out.printf("Total Payable:             RM %-4.2f\n", total);

        /* loyalty cashback */
        if (isMember) {
            System.out.printf("Loyalty Cashback (2%%):     RM %-4.2f\n", total * 0.02);
            //total *= 0.98;  // -2%
        }

        System.out.println("-----------------------------------");  // divider
        System.out.printf("Final Amount to Collect:   RM %-4.2f\n", total);
    }
}