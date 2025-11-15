import java.util.Scanner;

public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        /* username validation */
        boolean valid = true;
        char first = username.charAt(0);
        //first character must be a letter (A-Z or a-z)
        if (!((first >= 'A' && first <= 'Z') || (first >= 'a' && first <= 'z'))) {
            valid  = false;
        }

        //5-15 characters
        if (username.length() < 5 || username.length() > 15) {
            valid = false;
        }

        //letters, digits and underscores only
        for (int i = 1; i < username.length(); i++) {
            char ch = username.charAt(i);

            boolean letter = ch >= 'a' && ch <= 'z';
            boolean digit = ch >= '0' && ch <= '9';
            boolean underscore = ch == '_';
            if (!letter && !digit && !underscore) {
                valid = false;
            }
        }

        //no uppercase letters
        for (int i = 1; i < username.length(); i++) {
            char ch = username.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                valid = false;
            }
        }

        if (!valid) {
            System.out.println("Invalid username");
        }

        int strength = 0;
        //minimum 8 characters
        if (password.length() >= 8) {
            strength++;
        }
        //no username as substring
        if (!password.toLowerCase().contains(username.toLowerCase())) {
            strength++;
        }

        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean special = false;
        boolean spaces = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                uppercase = true;
            }
            if (ch >= 'a' && ch <= 'z') {
                lowercase = true;
            }
            if (ch >= '0' && ch <= '9') {
                digit = true;
            }
            //anything except letters and digits are special characters
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch == ' '))) {
                special = true;
            }
            if (ch == ' ') {
                spaces = true;
            }
        }

        if (uppercase) strength++;
        if (lowercase) strength++;
        if (digit) strength++;
        if (special) strength++;
        if (!spaces) strength++;

        System.out.print("Password Strength: ");
        if (strength <= 3) {
            System.out.print("Weak");
        } else if (strength <= 5) {
            System.out.print("Moderate");
        } else if (strength == 6) {
            System.out.print("Strong");
        } else {
            System.out.print("Very Strong");
        }
    }
}