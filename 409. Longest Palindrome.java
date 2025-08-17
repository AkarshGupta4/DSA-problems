class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        boolean[] used = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (!used[j] && s.charAt(i) == s.charAt(j)) {
                    count += 2;  
                    used[i] = true;
                    used[j] = true;
                    break;
                }
            }
        }

        if (count < s.length()) {
            return count + 1;
        }
        return count;
    }
}
