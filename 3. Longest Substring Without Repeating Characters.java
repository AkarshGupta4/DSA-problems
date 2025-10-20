

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}


// // dry run

// 🧩 Initial values:
// Variable	Value
// s	"abcabcbb"
// n	8
// left	0
// right	0
// maxLen	0
// set	{} (empty)
// 🔁 Step-by-step Dry Run:
// Step 1:

// right = 0 → c = 'a'

// 'a' not in set → add 'a'

// set = {a}

// maxLen = max(0, 0-0+1) = 1

// right++ → 1

// ✅ Status:
// set = {a}, left = 0, right = 1, maxLen = 1

// Step 2:

// right = 1 → c = 'b'

// 'b' not in set → add 'b'

// set = {a, b}

// maxLen = max(1, 1-0+1) = 2

// right++ → 2

// ✅ Status:
// set = {a, b}, left = 0, right = 2, maxLen = 2

// Step 3:

// right = 2 → c = 'c'

// 'c' not in set → add 'c'

// set = {a, b, c}

// maxLen = max(2, 2-0+1) = 3

// right++ → 3

// ✅ Status:
// set = {a, b, c}, left = 0, right = 3, maxLen = 3

// Step 4:

// right = 3 → c = 'a'

// 'a' already in set!

// Enter inner while loop:

// Remove s[left] = 'a' → set = {b, c}

// left++ → 1

// Now 'a' not in set → add 'a'

// set = {a, b, c}

// maxLen = max(3, 3-1+1) = 3

// right++ → 4

// ✅ Status:
// set = {a, b, c}, left = 1, right = 4, maxLen = 3

// Step 5:

// right = 4 → c = 'b'

// 'b' is in set → remove s[left] = 'b'

// set = {a, c}

// left++ → 2

// Add 'b'

// set = {a, b, c}

// maxLen = max(3, 4-2+1) = 3

// right++ → 5

// ✅ Status:
// set = {a, b, c}, left = 2, right = 5, maxLen = 3

// Step 6:

// right = 5 → c = 'c'

// 'c' is in set → remove s[left] = 'c'

// set = {a, b}

// left++ → 3

// Add 'c'

// set = {a, b, c}

// maxLen = max(3, 5-3+1) = 3

// right++ → 6

// ✅ Status:
// set = {a, b, c}, left = 3, right = 6, maxLen = 3

// Step 7:

// right = 6 → c = 'b'

// 'b' is in set → remove s[left] = 'a'

// set = {b, c}

// left++ → 4

// 'b' still in set → remove s[left] = 'b'

// set = {c}

// left++ → 5

// Add 'b'

// set = {b, c}

// maxLen = max(3, 6-5+1) = 3

// right++ → 7

// ✅ Status:
// set = {b, c}, left = 5, right = 7, maxLen = 3

// Step 8:

// right = 7 → c = 'b'

// 'b' in set → remove s[left] = 'c'

// set = {b}

// left++ → 6

// 'b' still in set → remove s[left] = 'b'

// set = {}

// left++ → 7

// Add 'b'

// set = {b}

// maxLen = max(3, 7-7+1) = 3

// right++ → 8 (loop ends)

// ✅ Final State:

// maxLen = 3

// 🎯 Final Answer:

// ✅ Output: 3

// 💡 Meaning:

// The longest substring without repeating characters in "abcabcbb" is any of:

// "abc"

// "bca"

// "cab"

// Each has length 3.