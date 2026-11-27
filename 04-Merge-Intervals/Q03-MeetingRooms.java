# Q3. Meeting Rooms

**LeetCode:** [252. Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)  
**Pattern:** Merge Intervals  
**Difficulty:** Easy  
**Language:** Java

## Approach

We need to determine whether a person can attend all meetings without any time overlap.

1. Sort all intervals by their starting time.
2. Compare each meeting with the previous meeting.
3. If the previous meeting's ending time is greater than the current meeting's starting time, they overlap.
4. Return `false` if there is an overlap; otherwise, return `true`.

## Java Solution

```java
import java.util.*;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }

        return true;
    }
}
```

## Example

**Input:**
```text
intervals = [[0,30],[5,10],[15,20]]
```

After sorting, compare:

| Previous meeting | Current meeting | Overlap? |
|---|---|---|
| [0,30] | [5,10] | Yes |

**Output:** `false`

## Complexity Analysis

- **Time Complexity:** O(n log n) — sorting the intervals.
- **Space Complexity:** O(1) auxiliary space, excluding sorting implementation details.

## Key Learning

- Sort intervals by starting time.
- If `previousEnd > currentStart`, meetings overlap.
- If `previousEnd == currentStart`, meetings do not overlap because one ends exactly when the other begins.

**Status:** Mark complete once accepted on LeetCode.
