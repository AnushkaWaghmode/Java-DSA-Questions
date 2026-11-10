# Q02 – Two Sum II: Input Array Is Sorted

**LeetCode:** [167. Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

**Pattern:** Two Pointers

**Difficulty:** Medium

## Approach: Two Pointers

- Initialize `left` at the beginning and `right` at the end.
- Calculate the sum of both elements.
- If the sum equals the target, return their 1-indexed positions.
- If the sum is smaller, increment `left`.
- If the sum is greater, decrement `right`.

## Java Solution

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) – Each pointer moves at most n times.
- **Space Complexity:** O(1) – No extra data structure is used.

## Key Learning

A sorted array allows us to use two pointers to find the required pair efficiently without using a HashMap.
