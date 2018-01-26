import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Pattern regex = Pattern.compile("[^A-Za-z0-9]");
    public static Matcher matcher;
    public static char[] spliterator;


    public static void main(String[] args) {
        String password;
        int entropyScore;
        //Scanner to take in user input
        Scanner input = new Scanner(System.in);
        //Request password
        System.out.println("Enter New Password: ");
        password = input.nextLine();
        entropyScore = calculateEntropy(password);

        //Debugging todo: remove before submission
        System.out.println("Password is: " + password);
        System.out.println("Entropy is: " + entropyScore);
        evaluateEntropy(entropyScore);
        System.out.println();

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


    //Determine the number of types of special characters in the string
    public static int countSpecialCharacters(String s) {
        spliterator = s.toCharArray();
        ArrayList<Character> temp = new ArrayList<>();
        int ret = 0;

        //Remove repeated characters
        for (int i = 0; i<= spliterator.length - 1; i++){
            if(temp.contains(spliterator[i]))
                spliterator[i] = '0';
            else temp.add(spliterator[i]);
        }
        //Scan password against regex pattern to determine number of special characters
        for (int i = 0; i <= spliterator.length - 1; i++) {
            matcher = regex.matcher(String.valueOf(spliterator[i]));
            if (matcher.find())
                ret++;
        }//end for
        return ret;//todo, checks for the number of special characters used in password
    }//end countSpecialCharacters

    public static boolean hasDigit(String s) {
        boolean ret = false;
        //Check password for digits
        if (s.matches(".*\\d+.*"))
            ret = true;
        return ret;//todo, checks if password contains a numeric value
    }//end hasDigit

    public static boolean hasUpperCase(String s) {
        boolean ret = false;
        if (!s.equals(s.toLowerCase()))
            ret = true;
        return ret;//todo, checks if password contains an uppercase character
    }//end hasUpperCase

    public static boolean hasLowerCase(String s) {
        boolean ret = false;
        if(!s.equals(s.toUpperCase()))
            ret = true;
        return ret;//todo, checks if password contains a lowercase character
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

        if(hasUpperCase(s))
            ret+=26;
        if(hasLowerCase(s))
            ret+=26;
        if(hasDigit(s))
            ret += 10;
        ret+=countSpecialCharacters(s);


        return ret;//todo, Calculates the range of a string
        /*Range starts at 0;
          Add 26 if the string contains an uppercase letter
          Add 26 if the string contains a lowercase letter
          Add 10 if the string contains a digit
          Add the total number of special characters used.
        */
    }//end calculateRange

    public static String truncate(String s, int n) {
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
    //Overloaded to allow for truncating numbers
    public static int truncate(double n){
        int ret = ((int) n);
        return ret;
    }

    //returns log of x in base 2
    public static double log2(double x) {
        double ret = Math.log(x)/Math.log(2);
        ret = Math.round((ret * 10000.0000)/10000.0000);

        return ret;
    }//end log2

    public static int calculateEntropy(String s) {
        //maxEntropy = log2(range^(length-1)
        double maxEntropy;
        double range = calculateRange(s);
        double length;

        length = s.length();

        maxEntropy = log2(Math.pow(range,(length - 1)));

        int ret = truncate(maxEntropy);

        return ret;


/*
where
E is an integer representing the maximum entropy. (Truncate the decimal part; don't round)
R is the range of the characters.
    range is 26 if only lower case letters are used
    range is 52 if upper and lower case letters are used
    range is 62 if upper, lower, and digits are used.
    range is 67 if upper, lower, digits, and 5 special characters are used.
     range is 72 if upper, lower, digits, and 10 special characters are used.
*/
    }//end calculateEntropy

    public static void evaluateEntropy(double entropy) {
        String ret = "Test_Value";
        //Evaluate Entropy
        if(entropy <= 64)
            ret = "Very Weak";
        else if(entropy >64 && entropy <= 80)
            ret = "Weak";
        else if(entropy >80 && entropy <= 112)
            ret = "Moderate";
        else if(entropy >112 && entropy <= 128)
            ret = "Strong";
        else if(entropy >128)
            ret = "Very Strong";
        //Print Evaluation
        System.out.println(ret);

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






























































