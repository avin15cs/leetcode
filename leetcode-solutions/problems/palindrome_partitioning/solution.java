class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        solve(s,new ArrayList<>(),list);

        return list;
    }

    void solve(String s, List<String> path, List<List<String>> list) {
        if(s.length()==0) {
            List<String> ans=new ArrayList<>(path);
            list.add(ans);
            return;
        }

        for(int i=0;i<s.length();i++) {
            String part=s.substring(0,i+1);
            if(isPalindrome(part)) {
                path.add(part);
                solve(s.substring(i+1),path,list);
                path.remove(path.size()-1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;

        while(i<j) {
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        
        return true;
    }
}