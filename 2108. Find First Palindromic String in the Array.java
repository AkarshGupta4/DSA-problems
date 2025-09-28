class Solution {
    public String firstPalindrome(String[] words) {
        
        int n = words.length;        

        for(int i=0; i<n; i++){
            String Word = words[i];
            int start = 0;
            int end = Word.length()-1;
            boolean ispalindrome = true;

            while(start<end){
                if(Word.charAt(start) != Word.charAt(end)){ 
                    ispalindrome = false;
                    break;
                }
                start++;
                end--;

            }
            if(ispalindrome){
                return Word;
            }
        }
        return "";
    }
}