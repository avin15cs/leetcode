class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];

        for(int i=0;i<s.length();i++) 
            map[s.charAt(i)-'a'] = i;

        List<Integer> result = new ArrayList<>();

        int start = 0, end = 0;

        for(int i =0;i<s.length();i++) {
            end = Math.max(map[s.charAt(i)-'a'],end);

            if(end==i) {
                result.add(end-start+1);
                start = end+1;
            }
        }
        return result;
    }
}