# Q10 - Sliding Window Maximum

**LeetCode:** [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)  
**Pattern:** Sliding Window + Monotonic Deque  
**Difficulty:** Hard

### Approach
- Use a Deque to store array indices.
- Maintain elements in decreasing order of their values.
- Remove indices that are outside the current window.
- Remove smaller elements from the back of the Deque.
- The front of the Deque always stores the index of the maximum element.
- Add the maximum to the result after the first window is complete.

### Java Code

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int right = 0; right < n; right++) {

            // Remove indices outside the window
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(right);

            // Store maximum after first window is complete
            if (right >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n) — Every index is added and removed from the Deque at most once.
- **Space Complexity:** O(k) — The Deque stores at most k indices, excluding the output array.

### Key Learning
- A Monotonic Deque maintains elements in decreasing order.
- Store indices instead of values so expired elements can be identified.
- The front always represents the maximum element in the current window.
- Each element is processed at most once.

**Status:** Solved after LeetCode acceptance.
