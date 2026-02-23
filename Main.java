import java.util.Scanner;

/**
 * Day 1 Java Roadmap — Console Calculator + Mini Utility Suite
 * Built by Lakshya – Day 1 Java Roadmap
 *
 * Features:
 *   - Calculator: add, subtract, multiply, divide, power, modulus
 *   - Number Tools: prime check, factorial, GCD, LCM, reverse number,
 *                   sum of digits, palindrome check, count digits
 *   - Input validation (no crashes on bad input)
 *   - History: stores last 5 calculator results
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    // History of last 5 calculator results
    static double[] history = new double[5];
    static int historyCount = 0;

    // ─────────────────────────────────────────────
    //  ENTRY POINT
    // ─────────────────────────────────────────────

    public static void main(String[] args) {
    

        while (true) {
            System.out.println("\n=== Utility Suite ===");
            System.out.println("1. Calculator");
            System.out.println("2. Number Tools");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (choice == 1) {
                calculatorMenu();
            } else if (choice == 2) {
                numberToolsMenu();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ─────────────────────────────────────────────
    //  INPUT HELPERS
    // ─────────────────────────────────────────────

    /** Read a valid integer; re-prompt on bad input. O(1) per valid input. */
    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    /** Read a valid double; re-prompt on bad input. O(1) per valid input. */
    static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    /** Read 'y' or 'n'. Returns true for 'y'. */
    static boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Please enter y or n.");
        }
    }

    // ─────────────────────────────────────────────
    //  HISTORY
    // ─────────────────────────────────────────────

    static void saveToHistory(double result) {
        // Shift array left if full — O(5) = O(1) since size is fixed
        if (historyCount == 5) {
            for (int i = 0; i < 4; i++) {
                history[i] = history[i + 1];
            }
            history[4] = result;
        } else {
            history[historyCount] = result;
            historyCount++;
        }
    }

    static void showHistory() {
        if (historyCount == 0) {
            System.out.println("No history yet.");
            return;
        }
        System.out.println("\n--- Last " + historyCount + " Results ---");
        for (int i = 0; i < historyCount; i++) {
            System.out.println("  " + (i + 1) + ". " + history[i]);
        }
    }

    // ─────────────────────────────────────────────
    //  CALCULATOR MENU
    // ─────────────────────────────────────────────

    static void calculatorMenu() {
        while (true) {
            System.out.println("\n--- Calculator ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power (a^b)");
            System.out.println("6. Modulus (a % b)");
            System.out.println("7. Show History");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int op = readInt();
            if (op == 0) return;
            if (op == 7) { showHistory(); continue; }

            System.out.print("Enter first number: ");
            double a = readDouble();
            System.out.print("Enter second number: ");
            double b = readDouble();

            double result;

            switch (op) {
                case 1:
                    result = add(a, b);
                    break;
                case 2:
                    result = subtract(a, b);
                    break;
                case 3:
                    result = multiply(a, b);
                    break;
                case 4:
                    if (b == 0) {
                        System.out.println("Cannot divide by zero.");
                        continue;
                    }
                    result = divide(a, b);
                    break;
                case 5:
                    result = power(a, (int) b);
                    break;
                case 6:
                    if (b == 0) {
                        System.out.println("Cannot mod by zero.");
                        continue;
                    }
                    result = modulus(a, b);
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            System.out.println("Result: " + result);
            saveToHistory(result);

            if (!readYesNo("Continue in Calculator?")) return;
        }
    }

    // ─────────────────────────────────────────────
    //  CALCULATOR OPERATIONS  — all O(1) except power
    // ─────────────────────────────────────────────

    static double add(double a, double b)      { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }
    static double divide(double a, double b)   { return a / b; }
    static double modulus(double a, double b)  { return a % b; }

    /**
     * Power using a loop — O(exp).
     * (Math.pow exists but we implement manually for learning.)
     */
    static double power(double base, int exp) {
        if (exp < 0) return 1.0 / power(base, -exp);
        double result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    // ─────────────────────────────────────────────
    //  NUMBER TOOLS MENU
    // ─────────────────────────────────────────────

    static void numberToolsMenu() {
        while (true) {
            System.out.println("\n--- Number Tools ---");
            System.out.println("1.  Prime Check");
            System.out.println("2.  Factorial");
            System.out.println("3.  GCD");
            System.out.println("4.  LCM");
            System.out.println("5.  Reverse Number");
            System.out.println("6.  Sum of Digits");
            System.out.println("7.  Palindrome Check");
            System.out.println("8.  Count Digits");
            System.out.println("9.  All Primes up to N");
            System.out.println("0.  Back");
            System.out.print("Choose: ");

            int op = readInt();
            if (op == 0) return;

            switch (op) {
                case 1: {
                    System.out.print("Enter n: ");
                    int n = readInt();
                    System.out.println(isPrime(n) ? n + " is Prime" : n + " is Not Prime");
                    break;
                }
                case 2: {
                    System.out.print("Enter n (0–20): ");
                    int n = readInt();
                    if (n < 0 || n > 20) {
                        System.out.println("Please enter a number between 0 and 20 to avoid overflow.");
                    } else {
                        System.out.println("Factorial: " + factorial(n));
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter a: ");
                    int a = readInt();
                    System.out.print("Enter b: ");
                    int b = readInt();
                    System.out.println("GCD: " + gcd(a, b));
                    break;
                }
                case 4: {
                    System.out.print("Enter a: ");
                    int a = readInt();
                    System.out.print("Enter b: ");
                    int b = readInt();
                    System.out.println("LCM: " + lcm(a, b));
                    break;
                }
                case 5: {
                    System.out.print("Enter n: ");
                    int n = readInt();
                    System.out.println("Reversed: " + reverseNumber(n));
                    break;
                }
                case 6: {
                    System.out.print("Enter n: ");
                    int n = readInt();
                    System.out.println("Sum of digits: " + sumDigits(n));
                    break;
                }
                case 7: {
                    System.out.print("Enter n: ");
                    int n = readInt();
                    System.out.println(isPalindrome(n) ? n + " is a Palindrome" : n + " is NOT a Palindrome");
                    break;
                }
                case 8: {
                    System.out.print("Enter n: ");
                    int n = readInt();
                    System.out.println("Digit count: " + countDigits(n));
                    break;
                }
                case 9: {
                    System.out.print("Enter N: ");
                    int n = readInt();
                    if (n < 2) {
                        System.out.println("No primes below 2.");
                    } else {
                        System.out.print("Primes up to " + n + ": ");
                        printPrimesUpTo(n);
                    }
                    break;
                }
                default:
                    System.out.println("Invalid option.");
            }

            if (!readYesNo("Continue in Number Tools?")) return;
        }
    }

    // ─────────────────────────────────────────────
    //  NUMBER TOOL IMPLEMENTATIONS
    // ─────────────────────────────────────────────

    /**
     * Prime check — O(√n).
     * Key insight: any factor > √n would require a paired factor < √n,
     * which we'd already have found. So we only need to check up to √n.
     */
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {   // O(√n)
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Factorial — O(n).
     * Returns -1 for negative input.
     */
    static long factorial(int n) {
        if (n < 0) return -1;
        long ans = 1;
        for (int i = 2; i <= n; i++) ans *= i;
        return ans;
    }

    /**
     * GCD via Euclid's algorithm — O(log min(a,b)).
     * One of the fastest algorithms for this problem.
     */
    static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     * LCM — O(log min(a,b)) — uses GCD formula: lcm(a,b) = |a*b| / gcd(a,b).
     */
    static long lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return (long) Math.abs(a) / gcd(a, b) * Math.abs(b);
    }

    /**
     * Reverse number — O(d) where d = number of digits.
     * Handles trailing zeros: 120 → 21, negatives: -123 → -321.
     */
    static int reverseNumber(int n) {
        int x = Math.abs(n);
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return n < 0 ? -rev : rev;
    }

    /**
     * Sum of digits — O(d).
     * Handles negatives by using absolute value.
     */
    static int sumDigits(int n) {
        int x = Math.abs(n);
        int sum = 0;
        while (x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }

    /**
     * Palindrome number check — O(d).
     * A number is a palindrome if it equals its reverse (e.g., 121, 1331).
     */
    static boolean isPalindrome(int n) {
        if (n < 0) return false;   // negatives are never palindromes
        return n == reverseNumber(n);
    }

    /**
     * Count digits — O(d).
     * Special case: 0 has 1 digit.
     */
    static int countDigits(int n) {
        if (n == 0) return 1;
        int x = Math.abs(n);
        int count = 0;
        while (x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    /**
     * Print all primes up to N using basic approach — O(n * √n).
     * (Sieve of Eratosthenes would be O(n log log n) — a Day 2+ topic.)
     */
    static void printPrimesUpTo(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
    }
}
