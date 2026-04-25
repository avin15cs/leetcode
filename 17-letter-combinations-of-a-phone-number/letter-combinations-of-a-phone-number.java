class Solution {

    private static final String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    // public List<String> letterCombinations(String digits) {
    //     List<String> ans = new ArrayList<>();
    //     backtrack(digits,0,new StringBuilder(),ans);
    //     return ans;
    // }


    // void backtrack(String digits, int index, StringBuilder sb, List<String> res) {
    //     if(index == digits.length()) {
    //         res.add(sb.toString());
    //         return;
    //     }

    //     String letters = map[digits.charAt(index)-'0'];

    //     for(char c: letters.toCharArray()) {
    //         sb.append(c);
    //         backtrack(digits,index+1,sb,res);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        
        result.add("");
        for(char digit: digits.toCharArray()) {
            String letters = map[digit - '0'];
            List<String> temp = new ArrayList<>();
            for(String prefix: result) {
                for(char c: letters.toCharArray())
                    temp.add(prefix+c);
            }
            result = temp;
        } 
        return result;
    }
}