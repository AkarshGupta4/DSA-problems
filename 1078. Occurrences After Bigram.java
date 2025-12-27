class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] word = text.split(" ");
         List<String> result = new ArrayList<>();
        for(int i= 0; i<word.length-2; i++){
            if(word[i].equals(first) && word[i+1].equals(second)){
                result.add(word[i+2]);
            }
        }
        return result.toArray(new String[0]);
    }
}