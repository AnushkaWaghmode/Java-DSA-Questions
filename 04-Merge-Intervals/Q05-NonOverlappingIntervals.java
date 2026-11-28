# Q5. Non-overlapping Intervals

**LeetCode:** [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)  
**Pattern:** Merge Intervals  
**Difficulty:** Medium  
**Language:** Java

## Approach: Greedy

We need to find the minimum number of intervals to remove so that the remaining intervals do not overlap.

1. Sort intervals by their ending time.
2. Keep track of the ending time of the last selected interval.
3. If the current interval starts before the last selected interval ends, they overlap. Remove the current interval.
4. Otherwise, select the current interval and update the ending time.

**Why sort by ending time?**

Choosing the interval that ends earliest leaves maximum space for future intervals.

## Java Solution

```java
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[1], b[1]));

        int removals = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < lastEnd) {
                removals++;
            } else {
                lastEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
```

## Example

**Input:**
```text
intervals = [[1,2],[2,3],[3,4],[1,3]]
```

After sorting by ending time:

```text
[[1,2],[2,3],[1,3],[3,4]]
```

- Select `[1,2]`.
- Select `[2,3]` because it does not overlap.
- Remove `[1,3]` because it overlaps.
- Select `[3,4]`.

**Output:** `1`

## Complexity Analysis

- **Time Complexity:** O(n log n) — sorting the intervals.
- **Space Complexity:** O(1) auxiliary space, excluding sorting implementation details.

## Key Learning

- This is a Greedy interval problem.
- Sort by ending time, not starting time.
- `currentStart < lastEnd` means overlap.
- Keep the interval that finishes earliest.

**Status:** Mark complete once accepted on LeetCode.
