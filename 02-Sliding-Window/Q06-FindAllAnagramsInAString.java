# Q06 - Find All Anagrams in a String

**LeetCode:** [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)  
**Pattern:** Sliding Window + Frequency Counting  
**Difficulty:** Medium

### Approach
- Use two frequency arrays of size 26.
- Store the character frequencies of `p`.
- Maintain a fixed-size window in `s` equal to `p.length()`.
- Compare the frequency arrays.
- If they match, add the starting index to the result.
- Slide the window by adding the incoming character and removing the outgoing character.

### Java Code

```java
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Count characters in p and first window of s
        for (int i = 0; i < m; i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(pFreq, windowFreq)) {
            result.add(0);
        }

        // Slide the window
        for (int right = m; right < n; right++) {
            windowFreq[s.charAt(right) - 'a']++;

            windowFreq[s.charAt(right - m) - 'a']--;

            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(right - m + 1);
            }
        }

        return result;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n) — Each window comparison takes O(26), which is constant.
- **Space Complexity:** O(1) auxiliary space — Two fixed-size frequency arrays are used, excluding the result list.

### Key Learning
- Anagrams require the same character frequencies.
- The window size is always equal to `p.length()`.
- When sliding, add the incoming character and remove the outgoing character.
- Store the starting index using `right - m + 1`.

**Status:** Solved after LeetCode acceptance.
