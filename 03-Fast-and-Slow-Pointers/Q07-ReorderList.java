# Q7. Reorder List

**LeetCode:** [143 – Reorder List](https://leetcode.com/problems/reorder-list/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Medium

## Approach

Use three steps: find the middle, reverse the second half, and merge both halves.

- Use slow and fast pointers to find the middle.
- Split the linked list into two halves.
- Reverse the second half.
- Merge both halves alternately.
- The list is reordered in place.

## Java Solution

```java
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // Merge both halves
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning

Fast and slow pointers find the middle of a linked list. Reversing and merging the second half helps reorder the list without extra space.

**Status:** Pending LeetCode acceptance.
