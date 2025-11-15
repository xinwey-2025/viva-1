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
        } else { // for valid username
            /* password validation */
            int strength = 0;
            int length = password.length();

            if (length >= 8) { // minimum 8 characters
                strength++;
            }
            if (password.matches(".*[A-Z].*")) { // at least one uppercase letter
                strength++;
            }
            if (password.matches(".*[a-z].*")) { // at least one lowercase letter
                strength++;
            }
            if (password.matches(".*[0-9].*")) { // at least one digit
                strength++;
            }
            if (password.matches(".*[!@#$%^&*].*")) { // at least one special character
                strength++;
            }
            if (!password.contains(" ")) { // must not contain spaces
                strength++;
            }
            if (!password.toLowerCase().contains(username.toLowerCase())) { // no username as a substring
                strength++;
            }

            if (strength <= 3) {
                System.out.println("Password Strength: Weak");
            } else if (strength <= 5) {
                System.out.println("Password Strength: Moderate");
            } else if (strength == 6) {
                System.out.println("Password Strength: Strong");
            } else {
                System.out.println("Password Strength: Very Strong");
            }
        }
    }
}