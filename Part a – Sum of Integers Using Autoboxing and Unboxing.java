// File: SumUsingAutoboxing.java
import java.util.*;

public class SumUsingAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers separated by space (e.g. 10 20 30), then press Enter:");
        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");  // split on spaces

        for (String part : parts) {
            // parse string -> int -> autobox to Integer when adding to ArrayList
            numbers.add(Integer.parseInt(part));
        }

        int sum = 0;
        // enhanced for-loop automatically unboxes Integer to int
        for (Integer num : numbers) {
            sum += num;
        }

        System.out.println("Numbers: " + numbers);
        System.out.println("Total Sum: " + sum);
        sc.close();
    }
}
