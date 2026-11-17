# Q05 - Permutation in String

**LeetCode:** [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)  
**Pattern:** Sliding Window + Frequency Counting  
**Difficulty:** Medium

### Approach
- Use two frequency arrays of size 26.
- Store the character frequencies of `s1`.
- Create a fixed-size window in `s2` equal to the length of `s1`.
- Compare the frequency arrays.
- Slide the window by adding the new character and removing the old character.
- Return true if both frequency arrays match.

### Java Code

```java
import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Count characters in s1 and first window of s2
        for (int i = 0; i < n; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        // Slide the fixed-size window
        for (int right = n; right < m; right++) {
            windowFreq[s2.charAt(right) - 'a']++;

            windowFreq[s2.charAt(right - n) - 'a']--;

            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(m) — Each window is checked using two fixed-size arrays of 26 elements.
- **Space Complexity:** O(1) — Only two arrays of size 26 are used.

Here, `m` is the length of `s2`.

### Key Learning
- A permutation requires equal character frequencies, not equal character order.
- The window size must always equal `s1.length()`.
- Add the incoming character and remove the outgoing character when sliding.

**Status:** Solved after LeetCode acceptance.
