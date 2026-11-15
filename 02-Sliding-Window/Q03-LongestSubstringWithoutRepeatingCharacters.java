# Q03 - Longest Substring Without Repeating Characters

**LeetCode:** [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)  
**Pattern:** Sliding Window + HashSet  
**Difficulty:** Medium

### Approach
- Use two pointers, `left` and `right`, to maintain a sliding window.
- Use a HashSet to store unique characters.
- If a duplicate appears, remove characters from the left until the duplicate is removed.
- Update the maximum window length.

### Java Code

```java
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(current);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n) — Each character is added and removed at most once.
- **Space Complexity:** O(min(n, charset size)) — The HashSet stores characters in the current window.

### Key Learning
When a duplicate appears, shrink the window from the left until all characters are unique again.

**Status:** Solved after LeetCode acceptance.
