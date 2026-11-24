# Q8. Find the Duplicate Number

**LeetCode:** [287 – Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Medium

## Approach

Use Floyd's Cycle Detection Algorithm.

- Treat array values as pointers to the next index.
- Initialize slow and fast at index 0.
- Move slow one step and fast two steps until they meet.
- Reset slow to index 0.
- Move both pointers one step at a time.
- The meeting point is the duplicate number.

## Java Solution

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find duplicate number
        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning

An array can be treated like a linked list when each element points to another index. Floyd's Cycle Detection can then find the duplicate without modifying the array or using extra space.

**Status:** Pending LeetCode acceptance.
