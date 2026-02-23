# Day 1 — Console Calculator + Mini Utility Suite

> **Built by Lakshya – Day 1 Java Roadmap**

A menu-driven Java console app that demonstrates core Java fundamentals and introduces DSA thinking through real, runnable code.

---

## Features

### 🧮 Calculator
| Operation | Complexity |
|-----------|-----------|
| Add / Subtract / Multiply / Divide | O(1) |
| Power (a^b) — loop-based, no `Math.pow` | O(b) |
| Modulus | O(1) |
| History (last 5 results stored in array) | O(1) |

### 🔢 Number Tools
| Tool | Complexity |
|------|-----------|
| Prime Check | O(√n) |
| Factorial | O(n) |
| GCD (Euclid's algorithm) | O(log min(a,b)) |
| LCM (uses GCD) | O(log min(a,b)) |
| Reverse Number | O(d) — d = digits |
| Sum of Digits | O(d) |
| Palindrome Check | O(d) |
| Count Digits | O(d) |
| All Primes up to N | O(n√n) |

### ✅ Input Validation
- No crashes on non-numeric input
- Divide/mod by zero is caught and handled
- Factorial limited to 0–20 to prevent overflow

---

## How to Run

### Option 1: Command Line

```bash
# Compile
javac src/main/java/Main.java -d out/

# Run
java -cp out Main
```

### Option 2: IntelliJ IDEA
1. Open the project folder in IntelliJ
2. Mark `src/main/java` as **Sources Root**
3. Run `Main.java`

### Option 3: VS Code
1. Install the **Extension Pack for Java**
2. Open the folder and run `Main.java` directly

---

## DSA Concepts Covered

### Time Complexity (applied to this project)

| Concept | Example in code |
|---------|----------------|
| O(1) — constant | `add()`, `subtract()` |
| O(n) — linear | `factorial()` loop |
| O(√n) — square root | `isPrime()` loop condition `i*i <= n` |
| O(log n) — logarithmic | `gcd()` Euclidean algorithm |
| O(d) — by digit count | `reverseNumber()`, `sumDigits()` |

### Why `i * i <= n` in prime check?
Any composite number `n` has at least one factor ≤ √n. If we reach √n without finding a factor, then `n` must be prime. Checking up to √n instead of up to n reduces work from O(n) to O(√n) — a massive speedup for large numbers.

### Arrays (light intro)
The history feature uses a fixed-size array of 5 doubles with a manual shift-left when full — a simple circular buffer pattern.

---

## Project Structure

```
Day1CalculatorSuite/
├── README.md
└── src/
    └── main/
        └── java/
            └── Main.java
```

---

## Day 1 Exercises Completed
- [x] Power (a^b) via loop
- [x] Modulus for integers
- [x] Continue y/n prompt after each operation
- [x] Factorial overflow guard (0–20 limit)
- [x] Palindrome number check
- [x] Count digits
- [x] History array (last 5 results)
- [x] LCM using GCD
- [x] All primes up to N

---

## Roadmap
- **Day 2:** Student Grade Analyzer · Arrays deepening · Strings intro
- **Day 3:** TBD
