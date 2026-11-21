# Q2. Middle of the Linked List

**LeetCode:** [876 – Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Easy

## Approach

Use two pointers moving at different speeds.

- Slow pointer moves one step at a time.
- Fast pointer moves two steps at a time.
- When fast reaches the end, slow points to the middle node.

## Java Solution

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning

When one pointer moves twice as fast as another, the slower pointer reaches the middle when the faster pointer reaches the end.

**Status:** Pending LeetCode acceptance.
