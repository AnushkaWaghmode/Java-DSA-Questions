# Q07 – Squares of a Sorted Array

**LeetCode:** [977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

**Pattern:** Two Pointers

**Difficulty:** Easy

## Approach: Two Pointers

- Initialize `left` at the beginning and `right` at the end.
- Compare the absolute values of both elements.
- Square the larger value and place it at the end of the result array.
- Move the corresponding pointer inward.
- Continue until all elements are processed.

## Java Solution

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Each element is processed once.
- **Space Complexity:** O(n) – An additional result array is created.

## Key Learning

Even though the original array is sorted, squaring negative numbers can change the order. Two pointers help place the largest squares first, working backwards through the result array.
