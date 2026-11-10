# Q03 – Valid Palindrome

**LeetCode:** [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

**Pattern:** Two Pointers

**Difficulty:** Easy

## Approach: Two Pointers

- Initialize `left` at the beginning and `right` at the end.
- Skip characters that are not letters or digits.
- Convert characters to lowercase before comparing.
- If characters don't match, return `false`.
- If all characters match, return `true`.

## Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Each character is visited at most once.
- **Space Complexity:** O(1) – No additional data structure is used.

## Key Learning

Two pointers can compare characters from opposite ends of a string while efficiently skipping unwanted characters.
