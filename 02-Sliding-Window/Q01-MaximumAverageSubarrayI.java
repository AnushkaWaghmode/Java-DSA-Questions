# Q01 – Maximum Average Subarray I

**LeetCode:** [643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)  
**Pattern:** Sliding Window  
**Difficulty:** Easy

## Approach: Fixed-Size Sliding Window

- Calculate the sum of the first `k` elements.
- Store this as the initial maximum sum.
- Slide the window one position at a time.
- Add the new element entering the window.
- Subtract the element leaving the window.
- Update the maximum sum.
- Return the maximum sum divided by `k`.

## Java Solution

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Each element is processed once.
- **Space Complexity:** O(1) – Only a few variables are used.

## Key Learning

In a fixed-size sliding window, instead of recalculating the sum every time, add the incoming element and subtract the outgoing element.

**Status:** Solved ✅
