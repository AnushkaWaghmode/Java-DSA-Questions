# Q5. Remove Nth Node From End of List

**LeetCode:** [19 – Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

**Pattern:** Fast and Slow Pointers

**Difficulty:** Medium

## Approach

Use two pointers with a dummy node.

- Create a dummy node pointing to head.
- Initialize slow and fast at dummy.
- Move fast `n + 1` steps ahead.
- Move both pointers until fast becomes null.
- Remove the required node using `slow.next = slow.next.next`.
- Return `dummy.next`.

## Java Solution

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Key Learning

Maintaining a fixed gap of `n + 1` between two pointers helps find the nth node from the end in one traversal.

**Status:** Pending LeetCode acceptance.
