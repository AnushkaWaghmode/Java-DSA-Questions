# Q06 – Move Zeroes

**LeetCode:** [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)

**Pattern:** Two Pointers

**Difficulty:** Easy

## Approach: Two Pointers

- Initialize `k = 0` to track the position of the next non-zero element.
- Traverse the array using pointer `i`.
- If `nums[i]` is non-zero, swap it with `nums[k]`.
- Increment `k`.
- This moves all zeroes to the end while maintaining the relative order of non-zero elements.

## Java Solution

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

                k++;
            }
        }
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Traverses the array once.
- **Space Complexity:** O(1) – Performs swapping in place.

## Key Learning

The slow pointer tracks the position for the next non-zero element, while the fast pointer searches for non-zero elements. This maintains their relative order without using extra space.
