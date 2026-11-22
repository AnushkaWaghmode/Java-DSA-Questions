# Q4. Happy Number

**LeetCode:** [202 – Happy Number](https://leetcode.com/problems/happy-number/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Easy

## Approach

Use Floyd's Cycle Detection Algorithm.

- Initialize slow and fast with `n`.
- Move slow one step using the sum of squares of digits.
- Move fast two steps using the same operation.
- If fast reaches `1`, the number is happy.
- If slow and fast meet before reaching `1`, a cycle exists, so the number is not happy.

## Java Solution

```java
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(log n) per digit-sum operation; cycle detection takes a bounded number of iterations for an integer input.
- **Space Complexity:** O(1)

## Key Learning

Fast and slow pointers can detect cycles in number sequences, not just linked lists.

**Status:** Pending LeetCode acceptance.
