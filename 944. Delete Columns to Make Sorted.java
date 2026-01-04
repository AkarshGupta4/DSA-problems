class Solution {
    public int minDeletionSize(String[] strs) {
        int r = strs.length;
        int c = strs[0].length();
        int del = 0;
        for(int j=0; j<c; j++){
            for(int i=0; i<r-1; i++){
                if(strs[i].charAt(j) > strs[i+1].charAt(j)){
                    del++;
                    break;
                }
            }
        }
        return del;
    }
}                                                                          