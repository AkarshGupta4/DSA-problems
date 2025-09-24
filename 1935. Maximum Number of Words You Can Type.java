class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int n = text.length();
        int b = brokenLetters.length();
        int count =0 ;
        boolean validword = true;

        for(int i=0; i<n; i++){
            char ch = text.charAt(i);
            for(int j=0; j<b; j++){
                if(text.charAt(i) == brokenLetters.charAt(j)){
                    validword = false;
                }
            }

            if(ch ==' '){
                if(validword){
                    count++;
                }
                validword=true;
            }
        }

        if(validword){
            count++;
        }
        return count;
    }
}