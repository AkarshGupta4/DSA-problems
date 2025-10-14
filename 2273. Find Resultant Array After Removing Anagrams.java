class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        String[] s = new String[n];

        for(int i= 0; i<n ; i++){
            char [] arr = words[i].toCharArray();
            Arrays.sort(arr);

            s[i] = new String(arr);

        }

        ans.add(words[0]);

        for(int i = 1; i<n; i++){
            if(!s[i-1].equals(s[i])){
                ans.add(words[i]);
            }
        }
        return ans;
    }
}