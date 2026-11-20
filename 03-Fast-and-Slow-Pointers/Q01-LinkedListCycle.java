# Q1. Linked List Cycle

**LeetCode:** [141 – Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Easy

## Approach
Use Floyd's Cycle Detection Algorithm.

- Slow pointer moves one step.
- Fast pointer moves two steps.
- If both pointers meet, return `true`.
- If fast reaches `null`, return `false`.

## Java Solution

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning
Two pointers moving at different speeds can detect a cycle in a linked list without using extra space.

**Status:** Pending LeetCode acceptance.
