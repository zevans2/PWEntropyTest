import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //Accessible Variables
    private static Pattern regex = Pattern.compile("[^A-Za-z0-9]");
    private static char[] spliterator;

    public static void main(String[] args) {
        String password;
        int entropyScore;
        //Scanner to take in user input
        Scanner input = new Scanner(System.in);
        //Request password
        System.out.println("Enter New Password: ");
        password = input.nextLine();
        entropyScore = calculateEntropy(password);
        System.out.println();//skip line

        //double for log2 equation
        double number = 40.0;

        //Could print this from method....
        System.out.println("Password: \t\t\t" + password);
        System.out.println("Entropy:\t\t\t" + entropyScore);
        System.out.println("Password Strength:\t" + evaluateEntropy(entropyScore));
        System.out.println("Special characters:\t" + countSpecialCharacters(password));
        System.out.println("Has Digit: \t\t\t" + hasDigit(password));
        System.out.println("Has Uppercase: \t\t" + hasUpperCase(password));
        System.out.println("Has Lowercase: \t\t" + hasLowerCase(password));
        System.out.println("Trimmed Length: \t" + trimmedLength(password));
        System.out.println("Truncated Password:\t" + truncate(password, 20));
        System.out.printf("Log2 of " + number + ":\t\t%.2f", log2(number));
        System.out.println();//skip line

    }//end main

    //Determine the number of types of special characters in the string
    public static int countSpecialCharacters(String s) {
        spliterator = s.toCharArray();
        ArrayList<Character> temp = new ArrayList<>();
        int ret = 0;
        //Remove repeated characters
        for (int i = 0; i <= spliterator.length - 1; i++) {
            if (temp.contains(spliterator[i]))
                spliterator[i] = '0';
            else temp.add(spliterator[i]);
        }
        //Scan password against regex pattern to determine number of special characters
        for (int i = 0; i <= spliterator.length - 1; i++) {
            Matcher matcher = regex.matcher(String.valueOf(spliterator[i]));
            if (matcher.find())
                ret++;
        }//end for
        return ret;
    }//end countSpecialCharacters

    public static boolean hasDigit(String s) {
        boolean ret = false;
        //Check password for digits
        if (s.matches(".*\\d+.*"))
            ret = true;
        return ret;
    }//end hasDigit

    public static boolean hasUpperCase(String s) {
        boolean ret = false;
        if (!s.equals(s.toLowerCase()))
            ret = true;
        return ret;
    }//end hasUpperCase

    public static boolean hasLowerCase(String s) {
        boolean ret = false;
        if (!s.equals(s.toUpperCase()))
            ret = true;
        return ret;
    }//end hasLowerCase

    public static int trimmedLength(String s) {
        int ret;
        String temp;
        temp = s.trim();
        ret = temp.length();
        return ret;
    }//end trimmedLength

    public static int calculateRange(String s) {
        int ret = 0;
        if (hasUpperCase(s)) //add 26 for lowercase letters
            ret += 26;
        if (hasLowerCase(s)) //add 26 for uppercase letters
            ret += 26;
        if (hasDigit(s))     //add 10 for containing digits
            ret += 10;
        ret += countSpecialCharacters(s); //add 1 for each type of special character used
        return ret;
    }//end calculateRange

    public static String truncate(String s, int n) {
        spliterator = s.toCharArray();
        StringBuilder ret = new StringBuilder();
        if (s.length() <= n)
            ret = new StringBuilder(s);
        else {
            //loop through and add each character until you have reached n length.
            for (int i = 0; i <= n - 1; i++) {
                ret.append(String.valueOf(spliterator[i]));
            }//end for
            //Append ellipses
            ret.append("...");
        }

        return ret.toString();
        //If n > password.length return password.
    }//end truncate

    //Overloaded to allow for truncating numbers
    private static int truncate(double n) {
        return ((int) n);
    }

    //returns log of x in base 2
    public static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }//end log2

    public static int calculateEntropy(String s) {
        //maxEntropy = log2(range^(length-1)
        double maxEntropy;
        double range = calculateRange(s);
        double length;

        length = s.length();
        if (length == 0) {//if password is blank
            return 0;
        }
        maxEntropy = log2(Math.pow(range, (length - 1)));
        return truncate(maxEntropy);
    }//end calculateEntropy

    public static String evaluateEntropy(double entropy) {
        String ret = "Test_Value";
        //Evaluate Entropy
        if (entropy <= 64)
            ret = "Very Weak";
        else if (entropy > 64 && entropy <= 80)
            ret = "Weak";
        else if (entropy > 80 && entropy <= 112)
            ret = "Moderate";
        else if (entropy > 112 && entropy <= 128)
            ret = "Strong";
        else if (entropy > 128)
            ret = "Very Strong";
        return ret;
        /*
        Entropy Strength Scale
        -----------------------
        0   -  64   Very Weak
        65  -  80   Weak
        81  -  112  Moderate
        113 -  128  Strong
        128 -       Very Strong
         */
    }//end evaluateEntropy
}//end application






























































