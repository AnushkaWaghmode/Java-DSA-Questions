# Q3. Linked List Cycle II

**LeetCode:** [142 – Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Medium

## Approach

Use Floyd's Cycle Detection Algorithm.

- Initialize slow and fast at head.
- Move slow one step and fast two steps.
- If they meet, a cycle exists.
- Reset slow to head.
- Move both pointers one step at a time.
- The node where they meet again is the cycle's starting point.
- If fast reaches null, return null.

## Java Solution

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Find cycle starting point
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning

After detecting a cycle, resetting one pointer to the head and moving both pointers one step at a time helps locate the cycle's starting node.

**Status:** Pending LeetCode acceptance.
