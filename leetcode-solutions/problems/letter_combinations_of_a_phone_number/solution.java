class Solution {
    String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        List<String> str = new ArrayList<>();
        for(char c: digits.toCharArray()) {
            String curAns = arr[c-'0'];
            if(ans.size() == 0) {
                str.add("");
            } else {
                str = ans;
                ans = new ArrayList<>();
            }
            for(char ch: curAns.toCharArray()) {
                for(String s: str) 
                    ans.add(s+ch);
            }

        }

        return ans;
    }
}