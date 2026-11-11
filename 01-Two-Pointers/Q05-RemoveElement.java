# Q05 – Remove Element

**LeetCode:** [27. Remove Element](https://leetcode.com/problems/remove-element/)

**Pattern:** Two Pointers

**Difficulty:** Easy

## Approach: Two Pointers

- Initialize `k = 0` to track the position of valid elements.
- Traverse the array using pointer `i`.
- If `nums[i]` is not equal to `val`, place it at `nums[k]`.
- Increment `k` whenever a valid element is found.
- Return `k`, the number of elements remaining.

## Java Solution

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Traverses the array once.
- **Space Complexity:** O(1) – Modifies the array in place.

## Key Learning

The slow pointer tracks the position where the next valid element should be placed, while the fast pointer searches for valid elements.
