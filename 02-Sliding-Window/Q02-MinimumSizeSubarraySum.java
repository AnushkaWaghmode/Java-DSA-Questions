# Q02 - Minimum Size Subarray Sum

**LeetCode:** [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)  
**Pattern:** Sliding Window (Variable Size)  
**Difficulty:** Medium

### Approach
- Expand the window by adding elements from the right.
- When the sum becomes greater than or equal to the target, update the minimum length.
- Shrink the window from the left while the condition remains satisfied.
- Return 0 if no valid subarray exists.

### Java Code

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n) — Each element enters and leaves the window at most once.
- **Space Complexity:** O(1) — No extra data structures are used.

### Key Learning
- Expand the window when the condition is not satisfied.
- Shrink the window when the condition is satisfied.
- This approach works because all array elements are positive.

**Status:** Solved after LeetCode acceptance.
