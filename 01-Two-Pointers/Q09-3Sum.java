# Q09 – 3Sum

**LeetCode:** [15. 3Sum](https://leetcode.com/problems/3sum/)  
**Pattern:** Two Pointers  
**Difficulty:** Medium

## Approach: Sorting + Two Pointers

- Sort the array.
- Fix one element using the `i` pointer.
- Initialize `left = i + 1` and `right = nums.length - 1`.
- Calculate the sum of the three elements.
- If the sum is zero, add the triplet to the result.
- If the sum is less than zero, move `left` forward.
- If the sum is greater than zero, move `right` backward.
- Skip duplicate elements to avoid duplicate triplets.

## Java Solution

```java
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));

                    left++;
                    right--;

                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return result;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n²) – Sorting takes O(n log n), followed by nested two-pointer traversal.
- **Space Complexity:** O(1) auxiliary space, excluding sorting implementation and output storage.

## Key Learning

Sorting + Two Pointers helps solve the 3Sum problem efficiently. Skipping duplicate elements ensures that each triplet appears only once.

**Status:** Solved ✅
