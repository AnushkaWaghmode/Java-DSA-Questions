# Q1. Merge Intervals

**LeetCode:** [56 – Merge Intervals](https://leetcode.com/problems/merge-intervals/)

**Pattern:** Merge Intervals

**Difficulty:** Medium

## Approach

Use sorting and merging.

- Sort intervals based on their starting values.
- Create a list to store merged intervals.
- Compare the current interval with the last interval.
- If they overlap, update the ending value to the maximum of both ending values.
- Otherwise, add the current interval to the result.
- Return the merged intervals.

## Java Solution

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            if (result.isEmpty() ||
                result.get(result.size() - 1)[1] < interval[0]) {

                result.add(interval);

            } else {

                result.get(result.size() - 1)[1] =
                    Math.max(
                        result.get(result.size() - 1)[1],
                        interval[1]
                    );
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n log n) – sorting the intervals.
- **Space Complexity:** O(n) – storing the merged intervals.

## Key Learning

Sorting intervals by their starting values makes it easy to identify overlapping intervals. If the current interval starts before or at the previous interval's end, merge them.

**Status:** Pending LeetCode acceptance.
