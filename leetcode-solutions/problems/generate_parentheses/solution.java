class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        solve(n,n,"",res);
        return res;
    }

    void solve(int open, int close, String ans, List<String> res) {
        if(open == 0 && close == 0) {
            res.add(ans);
            return;
        }

        if(open>0) {
            solve(open-1,close,ans+"(",res);
        }
        if(open<close){
            solve(open,close-1,ans+")",res);
        }
    }
}