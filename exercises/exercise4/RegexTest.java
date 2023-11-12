import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        //Example
        String[] inputStrings = {
                "Email: meng.ziqi@example.com",
                "Phone: +1 (000) 123-4567",
                "Date: 2023-11-11",
                "URL: https://www.example.com",
                "Zip Code: 12345",
                "Invalid Email: meng.ziqi.example.com"
        };

        //Regex Model
        String[] regexPatterns = {
                "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b",  // Email
                "\\+1\\s\\(\\d{3}\\)\\s\\d{3}-\\d{4}",                      // Phone
                "\\d{4}-\\d{2}-\\d{2}",                                      // Date
                "https://www\\.[A-Za-z0-9\\.-]+\\.[A-Z|a-z]{2,}",           // URL
                "\\d{5}",                                                   // Zip Code
        };

        // Check if match
        for (int i = 0; i < Math.min(inputStrings.length, regexPatterns.length); i++) {
            String input = inputStrings[i];
            String regex = regexPatterns[i];

            System.out.println("Input: " + input);

            // positive
            if (matches(input, regex)) {
                System.out.println("  Matched!");
            } else {
                System.out.println("  Not matched.");
            }

            // negative
            if (matchesNegative(input, regex)) {
                System.out.println("  Incorrectly matched!");
            } else {
                System.out.println("  Did not incorrectly match.");
            }

            System.out.println();
        }
    }

    // check if string match
    private static boolean matches(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // check if string not match
    private static boolean matchesNegative(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}
