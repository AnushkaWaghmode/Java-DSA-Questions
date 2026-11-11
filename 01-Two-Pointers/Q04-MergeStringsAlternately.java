# Q04 – Merge Strings Alternately

**LeetCode:** [1768. Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/)

**Pattern:** Two Pointers

**Difficulty:** Easy

## Approach: Two Pointers

- Initialize two pointers `i` and `j` for both strings.
- Pick one character from `word1`, then one from `word2`.
- Continue until both strings are completely traversed.
- If one string is longer, append its remaining characters.

## Java Solution

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;

        while (i < word1.length() || j < word2.length()) {

            if (i < word1.length()) {
                result.append(word1.charAt(i));
                i++;
            }

            if (j < word2.length()) {
                result.append(word2.charAt(j));
                j++;
            }
        }

        return result.toString();
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n + m) – Each character is visited once.
- **Space Complexity:** O(n + m) – Stores the merged string.

## Key Learning

Two pointers can traverse two strings simultaneously and combine their characters in alternating order.
