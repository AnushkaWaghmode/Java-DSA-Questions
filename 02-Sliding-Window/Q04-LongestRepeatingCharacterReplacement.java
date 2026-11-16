# Q04 - Longest Repeating Character Replacement

**LeetCode:** [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)  
**Pattern:** Sliding Window + Frequency Counting  
**Difficulty:** Medium

### Approach
- Use a frequency array of size 26 to count uppercase English letters.
- Expand the window using the right pointer.
- Track the maximum frequency of a character in the current window.
- If `window length - maxFrequency > k`, shrink the window from the left.
- Maintain the maximum valid window length.

### Java Code

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            freq[current - 'A']++;

            maxFreq = Math.max(maxFreq, freq[current - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n) — Each character is processed at most twice.
- **Space Complexity:** O(1) — The frequency array always has 26 elements.

### Key Learning
**Replacements Needed = Window Length − Maximum Character Frequency**

A window is valid when:

`Window Length - Maximum Frequency <= k`

**Status:** Solved after LeetCode acceptance.
