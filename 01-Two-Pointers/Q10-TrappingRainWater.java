# Q10 – Trapping Rain Water

**LeetCode:** [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)  
**Pattern:** Two Pointers  
**Difficulty:** Hard

## Approach: Two Pointers

- Initialize `left` and `right` at the beginning and end of the array.
- Maintain `leftMax` and `rightMax` to track the maximum heights encountered.
- Compare the heights at both pointers.
- If the left height is smaller, calculate trapped water using `leftMax` and move `left` forward.
- Otherwise, calculate trapped water using `rightMax` and move `right` backward.
- Add the trapped water at each position to the total.

## Java Solution

```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Each pointer traverses the array at most once.
- **Space Complexity:** O(1) – Only constant extra variables are used.

## Key Learning

Water trapped at a position depends on the maximum height on its left and right sides.

The two-pointer technique calculates trapped water efficiently without using extra arrays.

**Status:** Solved ✅
