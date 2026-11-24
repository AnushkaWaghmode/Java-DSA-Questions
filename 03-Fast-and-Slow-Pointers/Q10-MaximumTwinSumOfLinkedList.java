# Q10. Maximum Twin Sum of a Linked List

**LeetCode:** [2130 – Maximum Twin Sum of a Linked List](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Medium

## Approach

Use fast and slow pointers to find the middle, then reverse the second half.

- Initialize slow and fast at head.
- Move slow one step and fast two steps.
- When fast reaches the end, slow points to the middle.
- Reverse the second half of the linked list.
- Compare corresponding nodes from both halves.
- Calculate twin sums and return the maximum.

## Java Solution

```java
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Calculate maximum twin sum
        int maxSum = 0;
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            int sum = first.val + second.val;
            maxSum = Math.max(maxSum, sum);

            first = first.next;
            second = second.next;
        }

        return maxSum;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning

Fast and slow pointers help find the middle of a linked list. Reversing the second half allows us to calculate twin sums efficiently without using extra space.

**Status:** Pending LeetCode acceptance.
