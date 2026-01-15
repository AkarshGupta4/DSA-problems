class Solution {
    public String largestGoodInteger(String num) {

        char max = 0;

        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                if (c > max) {
                    max = c;
                }
            }
        }

        if (max == 0) return "";
        return "" + max + max + max;
    }
}
