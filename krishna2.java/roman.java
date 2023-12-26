import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();

        int result = romanToInt(romanNumeral);
        System.out.println("Integer value: " + result);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int prevValue = 0;
        int total = 0;

        for (char c : s.toCharArray()) {
            int currValue = romanValues.get(c);
            total += currValue;

            if (currValue > prevValue) {
                total -= 2 * prevValue;  // Subtract twice the previous value since it was added once unnecessarily
            }

            prevValue = currValue;
        }

        return total;
    }
}