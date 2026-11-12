# Q08 – Container With Most Water

**LeetCode:** [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)  
**Pattern:** Two Pointers  
**Difficulty:** Medium

## Approach: Two Pointers

- Initialize `left` at the beginning and `right` at the end.
- Calculate the area using the shorter height and the distance between pointers.
- Update the maximum area.
- Move the pointer pointing to the shorter height because it limits the water capacity.
- Repeat until both pointers meet.

## Java Solution

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;

            int currentArea = Math.min(height[left], height[right]) * width;

            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Each pointer moves through the array at most once.
- **Space Complexity:** O(1) – Only constant extra space is used.

## Key Learning

The container's water capacity is limited by its shorter boundary. Moving the shorter pointer gives a chance to find a taller boundary and increase the area.

**Status:** Solved ✅
