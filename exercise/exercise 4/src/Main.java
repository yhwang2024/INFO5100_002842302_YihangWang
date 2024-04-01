import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        // Example patterns
        String[] patterns = {
                "^[a-zA-Z]+$", // Pattern 1: Matches a string that contains only letters (a-z, A-Z)
                "^\\d+$",      // Pattern 2: Matches a string that contains only digits (0-9)
                "^[a-zA-Z0-9]+$", // Pattern 3: Matches alphanumeric characters (a-z, A-Z, 0-9)
                "^.{8,}$",     // Pattern 4: Matches any string of at least 8 characters
                "^[^\\s]+$"    // Pattern 5: Matches a string that does not contain any whitespace characters
        };

        // Subject strings for positive and negative cases
        String[][] subjects = {
                {"HelloWorld", "12345"}, // Test strings for Pattern 1
                {"123456", "abcd"},      // Test strings for Pattern 2
                {"Hello123", "Hello@123"}, // Test strings for Pattern 3
                {"12345678", "12345"},   // Test strings for Pattern 4
                {"NoSpaces", "With Spaces"} // Test strings for Pattern 5
        };

        for (int i = 0; i < patterns.length; i++) {
            Pattern pattern = Pattern.compile(patterns[i]);
            System.out.println("Testing Pattern " + (i+1) + ": " + patterns[i]);

            for (int j = 0; j < subjects[i].length; j++) {
                Matcher matcher = pattern.matcher(subjects[i][j]);
                boolean matchFound = matcher.matches();
                System.out.println("  Subject: \"" + subjects[i][j] + "\" - " + (matchFound ? "Positive" : "Negative") + " Case");
            }
            System.out.println();
        }
    }
}
