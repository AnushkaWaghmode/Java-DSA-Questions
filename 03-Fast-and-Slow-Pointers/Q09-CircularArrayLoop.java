# Q9. Circular Array Loop

**LeetCode:** [457 – Circular Array Loop](https://leetcode.com/problems/circular-array-loop/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Medium

## Approach

Use Floyd's Cycle Detection Algorithm with direction checking.

- Start from each index.
- Use slow and fast pointers to move through the circular array.
- Move slow one step and fast two steps.
- Ensure all movements follow the same direction.
- If both pointers meet in a valid cycle, return true.
- Otherwise, mark the traversed path as visited and continue.

## Java Solution

```java
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextIndex(nums, slow, forward);

                if (slow == -1) {
                    break;
                }

                fast = nextIndex(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                fast = nextIndex(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }

            // Mark the invalid path as visited
            int current = i;

            while (nums[current] != 0 &&
                   (nums[current] > 0) == forward) {

                int next = getNextIndex(nums, current);
                nums[current] = 0;
                current = next;
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int current,
                          boolean forward) {
        if (nums[current] == 0 ||
            (nums[current] > 0) != forward) {
            return -1;
        }

        int next = getNextIndex(nums, current);

        if (next == current) {
            return -1;
        }

        return next;
    }

    private int getNextIndex(int[] nums, int current) {
        int n = nums.length;
        return ((current + nums[current]) % n + n) % n;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) overall.
- **Space Complexity:** O(1).

## Key Learning

Floyd's Cycle Detection can be applied to circular arrays. Direction checking and preventing self-loops are necessary to identify only valid cycles.

**Note:** This solution modifies the input array by marking visited elements as zero.

**Status:** Pending LeetCode acceptance.
