class Solution {
    public int reverse(int x) {
        long num = x;
        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder(Long.toString(num));
        sb.reverse();
        long reversed = Long.parseLong(sb.toString());

        if (negative) reversed = -reversed;

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        return (int) reversed;
    }
}