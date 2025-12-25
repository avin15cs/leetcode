class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList); 
        if(!dict.contains(endWord))
            return 0;

        // Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();

        q.add(beginWord);

        int len=0;

        while(!q.isEmpty()) {
            int size = q.size();
            len++;

            for(int i=0;i<size;i++) {
                String current = q.remove();

                for(int j=0;j<current.length();j++) {
                    char[] temp = current.toCharArray();
                    for(char c='a';c<='z';c++) {
                        temp[j]=c;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord))
                            return len+1;
                        
                        if(dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord);
                            // visited.add(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}