// // ye code me time exceed ho rha hai n = 1162261466 par
// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if (n <= 0) return false;
//         int x = 1;
//         while (x < n) {
//             x *= 4;
//         }
//         return x == n;
//     }
// }


// this is the optimize code  using loop 

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
