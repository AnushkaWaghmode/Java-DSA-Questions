# Q08 - Max Consecutive Ones III

**LeetCode:** [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)  
**Pattern:** Sliding Window (Variable Size)  
**Difficulty:** Medium

### Approach
- Use two pointers to maintain a sliding window.
- Count the number of zeroes in the current window.
- Expand the window by moving the right pointer.
- If zeroes exceed `k`, shrink the window from the left.
- Update the maximum window length.

### Java Code

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n) — Each element enters and leaves the window at most once.
- **Space Complexity:** O(1) — Only a few variables are used.

### Key Learning
- A valid window contains at most `k` zeroes.
- Expand the window when possible.
- Shrink it whenever the constraint is violated.
- The answer is the maximum valid window length.

**Status:** Solved after LeetCode acceptance.
