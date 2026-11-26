# Q2. Insert Interval

**LeetCode:** [57. Insert Interval](https://leetcode.com/problems/insert-interval/)  
**Pattern:** Merge Intervals  
**Difficulty:** Medium  
**Language:** Java

## Approach: Three Steps

The given intervals are already sorted and non-overlapping, so we don't need to sort them again.

1. **Add intervals before the new interval:** If an interval ends before the new interval starts, add it directly.
2. **Merge overlapping intervals:** If an interval overlaps with the new interval, update the new interval's start and end.
3. **Add remaining intervals:** Add the merged interval and all remaining intervals.

## Java Solution

```java
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Step 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n) — each interval is processed once.
- **Space Complexity:** O(n) — for the result list.

## Key Learning

- No sorting is required because intervals are already sorted.
- `intervals[i][1] < newInterval[0]` means the interval is before the new interval.
- `intervals[i][0] <= newInterval[1]` means the intervals overlap.
- Use `Math.min()` and `Math.max()` to merge intervals.

**Status:** Mark complete once accepted on LeetCode.
