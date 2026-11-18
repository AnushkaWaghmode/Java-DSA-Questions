# Q07 - Fruit Into Baskets

**LeetCode:** [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)  
**Pattern:** Sliding Window + HashMap  
**Difficulty:** Medium

### Approach
- Use a HashMap to store fruit types and their frequencies.
- Expand the window by moving the right pointer.
- If the map contains more than two distinct types, shrink the window from the left.
- Remove fruit types whose frequency becomes zero.
- Maintain the maximum window length.

### Java Code

```java
import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                int fruit = fruits[left];

                map.put(fruit, map.get(fruit) - 1);

                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

### Complexity Analysis
- **Time Complexity:** O(n) — Each element enters and leaves the window at most once.
- **Space Complexity:** O(1) — The map stores at most three fruit types temporarily.

### Key Learning
- This problem is equivalent to finding the longest subarray with at most two distinct elements.
- Use a HashMap to maintain frequencies.
- Shrink the window whenever the number of distinct elements exceeds 2.

**Status:** Solved after LeetCode acceptance.
