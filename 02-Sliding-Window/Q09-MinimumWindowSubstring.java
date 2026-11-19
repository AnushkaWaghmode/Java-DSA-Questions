# Q09 - Minimum Window Substring

**LeetCode:** [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)  
**Pattern:** Sliding Window + Frequency Counting  
**Difficulty:** Hard

### Approach
- Use a frequency array to store the required characters of `t`.
- Expand the window using the right pointer.
- Track the number of matched characters, including duplicates.
- When all required characters are matched, shrink the window from the left.
- Update the minimum window length and its starting index.
- Return the smallest valid substring.

### Java Code

```java
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (freq[current] > 0) {
                required--;
            }

            freq[current]--;

            while (required == 0) {
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n + m) — We process both strings and each pointer moves at most n times.
- **Space Complexity:** O(1) — The frequency array has a fixed size of 128.

Here, `n` is the length of `s` and `m` is the length of `t`.

### Key Learning
- Expand until the window becomes valid.
- Shrink while the window remains valid to find the smallest possible window.
- Track duplicate characters using frequency counts.
- `required` represents the number of characters still needed, including duplicates.

**Status:** Solved after LeetCode acceptance.
