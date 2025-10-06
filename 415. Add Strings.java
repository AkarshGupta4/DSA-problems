class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        char[] arr1 = num1.toCharArray(); 
        char[] arr2 = num2.toCharArray();

        int carry = 0;
        StringBuilder sb = new StringBuilder();

         while (i >= 0 || j >= 0 || carry > 0){
            int x = i >= 0 ? arr1[i] - '0' : 0; // yahan pe cah ko int me change kar rhe hai 
            int y = j >= 0 ? arr2[j] - '0' : 0; // yahan pe bhi 

            int sum = carry + x + y;
            carry = sum /10;
            sb.append(sum%10);

            i--;
            j--;
        }

        return sb.reverse().toString();
         
    }
}