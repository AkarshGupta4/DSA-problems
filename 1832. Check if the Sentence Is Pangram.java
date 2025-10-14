class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> sh = new HashSet<>();

        for(int i=0; i<sentence.length(); i++){
            sh.add(sentence.charAt(i));
        }
        return sh.size() == 26;
    }
}