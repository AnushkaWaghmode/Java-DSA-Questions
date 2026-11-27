# Q4. Meeting Rooms II

**LeetCode:** [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)  
**Pattern:** Merge Intervals  
**Difficulty:** Medium  
**Language:** Java

## Approach: Min Heap

We need to find the minimum number of meeting rooms required so that no meetings overlap in the same room.

1. Sort meetings by their starting time.
2. Use a Min Heap to store the ending times of meetings.
3. If the earliest-ending meeting finishes before or exactly when the current meeting starts, reuse that room by removing its ending time.
4. Add the current meeting's ending time to the heap.
5. The heap size gives the minimum number of rooms required.

## Java Solution

```java
import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] meeting : intervals) {

            // Reuse a room if the earliest meeting has ended
            if (!minHeap.isEmpty() && minHeap.peek() <= meeting[0]) {
                minHeap.poll();
            }

            // Add the current meeting's ending time
            minHeap.offer(meeting[1]);
        }

        return minHeap.size();
    }
}
```

## Example

**Input:**
```text
intervals = [[0,30],[5,10],[15,20]]
```

| Meeting | Heap (ending times) | Rooms |
|---|---|---:|
| [0,30] | [30] | 1 |
| [5,10] | [10,30] | 2 |
| [15,20] | [20,30] | 2 |

**Output:** `2`

## Complexity Analysis

- **Time Complexity:** O(n log n) — sorting and heap operations.
- **Space Complexity:** O(n) — Min Heap.

## Key Learning

- A Min Heap helps track the meeting that ends earliest.
- `peek()` gives the earliest ending time.
- `poll()` removes that meeting when its room becomes available.
- `offer()` adds the current meeting's ending time.
- The heap size represents the number of rooms currently needed.

**Status:** Mark complete once accepted on LeetCode.
