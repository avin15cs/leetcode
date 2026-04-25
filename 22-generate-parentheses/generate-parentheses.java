class Solution {
    // public List<String> generateParenthesis(int n) {
    //     List<String> res=new ArrayList<>();
    //     solve(n,n,"",res);
    //     return res;
    // }

    // void solve(int open, int close, String ans, List<String> res) {
    //     if(open == 0 && close == 0) {
    //         res.add(ans);
    //         return;
    //     }

    //     if(open>0) {
    //         solve(open-1,close,ans+"(",res);
    //     }
    //     if(open<close){
    //         solve(open,close-1,ans+")",res);
    //     }
    // }


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n , n, new StringBuilder(), ans);
        return ans;
    }

    void backtrack(int open, int close, StringBuilder sb, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(sb.toString());
            return;
        }

        if(open>0) {
            sb.append("(");
            backtrack(open-1,close,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }

        if(open<close) {
            sb.append(")");
            backtrack(open, close-1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}