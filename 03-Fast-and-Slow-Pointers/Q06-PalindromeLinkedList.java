# Q6. Palindrome Linked List

**LeetCode:** [234 – Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Easy

## Approach

Use fast and slow pointers to find the middle, then reverse the second half.

- Initialize slow and fast at head.
- Move slow one step and fast two steps.
- Reverse the second half of the linked list.
- Compare both halves node by node.
- If all values match, return true; otherwise, return false.

## Java Solution

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning

Fast and slow pointers help find the middle of a linked list. Reversing the second half allows palindrome checking without using extra space.

**Status:** Pending LeetCode acceptance.
