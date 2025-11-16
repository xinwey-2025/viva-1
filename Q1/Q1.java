import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        System.out.println("****Encik Hafiz's Library Fine System****");
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter number or books returning: ");
        // Identify loops
        int numBooks = input.nextInt();

        for (int i = 1; i <= numBooks; i++) {
            /* initial declaration */
            double price;
            double fineRate;
            double penalty = 0.0; //  simple penalty
            double totalPrice = 0.0;
            double discount = 1.0; // for those not available for discount will time 1.0
            double xPenalty = 0.0; // extra penalty

            /* prompt user for input */
            //System.out.print("Please enter days overdue: ");
            int days = input.nextInt();
            //System.out.print("Please enter book type code (R/G/M/C/T): ");
            char bookType = input.next().charAt(0);
            //System.out.print("Please enter borrower category (S for Student, T for Staff): ");
            char category = input.next().charAt(0);
            //System.out.print("Please enter number of previous late returns: ");
            int lateCount = input.nextInt();

            if (days < 0 ||
                    (bookType != 'R' && bookType != 'G' && bookType != 'M' && bookType != 'C' && bookType != 'T') ||
                    (category != 'T' && category != 'S'))
            {
                System.out.println("Invalid input. Re-enter...\n");
                i--;
                continue;
            }
            switch (bookType) {
                case 'R':
                    price = 100.0;
                    break;
                case 'G':
                    if (days <= 7) {
                        // b4 7 day
                        price = days * 0.50;

                    } else if (days <= 30) {
                        // calculate b4 7 day, then calculate between 7 day and 30 day
                        price = (7 * 0.50) + ((days - 7) * 1.00);

                    } else {
                        // calculate b4 7 day, calculate between 7 day and 30 day, then calculate after 30 day
                        price = (7 * 0.50) + (23 * 1.00) + ((days - 30) * 2.00);
                    }
                    break;
                case 'C':
                    double sum = 0 ;
                    for (int q = 1; q <= days; q++) {
                        if(q <= 10){
                            sum = sum + 2.0;
                        }
                        else {
                            sum = sum + 5.0;
                        }
                    }
                    price = sum;
                    break;
                case 'M':
                    fineRate = 0.20;
                    price = ((double) days * fineRate);
                    break;
                default:
                    if (days <= 15) {
                        fineRate = 10.0;
                    }
                    else {
                        fineRate = 10.0;
                        penalty = 200.0;
                    }
                    price = ((double) days * fineRate) + penalty;
                    break;
                }

                if (days > 60){
                    xPenalty += 25.00;
                }

                if (lateCount >= 3){
                    System.out.println("Habitual Offenders! RM10 PENALTY!!");
                    xPenalty += 10;
                }

                // Staff status 'T' is checked before Good Borrower status
                if (category == 'T') {
                    System.out.println("You're Staff! 20% DISCOUNTED!!");
                    discount = 0.80;
                } else if (lateCount == 0 && days <= 3) {
                    System.out.println("Good Borrower Reward! 50% DISCOUNTED!!");
                    discount = 0.50;
                }

                // Calculate the total price including discount and extra penalty
                totalPrice = (price * discount) + xPenalty;


            System.out.println("--- Case " + i + " --- ");
            System.out.printf("Total Fine: RM %.2f\n", totalPrice);
        }
    }
}