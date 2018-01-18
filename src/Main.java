import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Pattern regex = Pattern.compile("[^A-Za-z0-9]");
    public static Matcher matcher;
    public static char[] spliterator;


    public static void main(String[] args) {
        String password;
        Pattern regex = Pattern.compile("[^A-Za-z0-9]");
        char[] validCharacters;
        int entropyScore;

        //Scanner to take in user input
        Scanner input = new Scanner(System.in);

        //Request password
        System.out.println("Enter New Password: ");
        password = input.nextLine();

        //until methods are figured out
        entropyScore = -99;

        //Debugging todo: remove before submission
        System.out.println("Password is: " + password);
        System.out.println("Entropy is: " + entropyScore);

        //Until I have time to utilize a regex pattern todo: implement Regex comparator
        //Lowercase characters
        validCharacters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                //Uppercase characters
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                //Special Characters
                ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '>', '=', '?', '@', '[', ']', '\\', '^', '_', '`', '{', '|', '}', '~'};

        int specialCharacterCount = countSpecialCharacters(password);

        //double for log2 equation
        double number = 20.0;

        //Could print this from method....
        System.out.println("Special characters:\t" + specialCharacterCount);
        System.out.println("Has Digit: \t\t\t" + hasDigit(password));
        System.out.println("Has Uppercase: \t\t" + hasUpperCase(password));
        System.out.println("Has Lowercase: \t\t" + hasLowerCase(password));
        System.out.println("Trimmed Length: \t " + trimmedLength(password));
        System.out.println("Truncated Password:\t" + truncate(password, 20));
        System.out.println("Log2 of " + number + ":\t\t" + log2(number));
    }//end main


    public static int countSpecialCharacters(String s) {
        spliterator = s.toCharArray();
        int ret = 0;
        //Scan password against regex pattern to determine number of special characters
        for (int i = 0; i <= spliterator.length - 1; i++) {
            matcher = regex.matcher(String.valueOf(spliterator[i]));
            if (matcher.find())
                ret++;
        }//end for
        return ret;//todo, checks for the number of special characters used in password
    }//end countSpecialCharacters

    private static boolean hasDigit(String s) {
        boolean ret = false;
        //Check password for digits
        if (s.matches(".*\\d+.*"))
            ret = true;
        return ret;//todo, checks if password contains a numeric value
    }//end hasDigit

    private static boolean hasUpperCase(String s) {
        boolean ret = false;
        if (!s.equals(s.toLowerCase()))
            ret = true;
        return ret;//todo, checks if password contains an uppercase character
    }//end hasUpperCase

    private static boolean hasLowerCase(String s) {
        boolean ret = false;
        if(!s.equals(s.toUpperCase()))
            ret = true;
        return ret;//todo, checks if password contains a lowercase character
    }//end hasLowerCase

    private static int trimmedLength(String s) {
        int ret;
        String temp;
        temp = s.trim();
        ret = temp.length();
        return ret;
    }//end trimmedLength

    private static int calculateRange(String s, String allowedCharacters) {
        int ret = 0;
        return ret;//todo, Calculates the range of a string
        /*Range starts at 0;
          Add 26 if the string contains an uppercase letter
          Add 26 if the string contains a lowercase letter
          Add 10 if the string contains a digit
          Add the total number of special characters used.
        */
    }//end calculateRange

    private static String truncate(String s, int n) {
        spliterator = s.toCharArray();
        String ret = "";
        if (s.length() <= n)
            ret = s;
        else {
            //loop through and add each character until you have reached n length.
            for (int i = 0; i <= n-1; i++) {
                ret = (ret + String.valueOf(spliterator[i]));
            }//end for
        //Append ellipses
        ret = (ret + "...");
        }

        return ret;//todo, return the first n characters of password appended by (...).
        //If n > password.length return password.
    }//end truncate

    private static double log2(double x) {
        double ret = Math.log(x)/Math.log(2);
        ret = Math.round((ret * 10000.0000)/10000.0000);


        return ret;//todo, returns log of x in base 2.
        //Tests should be run to 0.0001 precision.
        //Calculate the answer in unit tests from an independent source such as a calculator
    }//end log2

    private static int calculateEntropy(String s, String allowedCharacters) {
        int ret = 0;
        return ret;//todo, calculate the level of entropy of the password.
        //calculate to 0.1 level of precision
    }//end calculateEntropy

    private static String evaluateEntropy(double entropy) {
        String ret = "test";
        return ret;//todo, evaluate the level of Entropy of the password and display password strength.
        /*
        Entropy Strength Scale
        -----------------------
        0   -  64   Very Weak
        65  -  80   Weak
        81  -  112  Moderate
        113 -  128  Strong
        128 -       Very Strong
         */

    }

}//end application






























































