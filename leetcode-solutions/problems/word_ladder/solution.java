class Solution {
    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     Set<String> dict = new HashSet<>(wordList); 
    //     if(!dict.contains(endWord))
    //         return 0;

    //     Queue<String> q=new LinkedList<>();

    //     q.add(beginWord);

    //     int len=0;

    //     while(!q.isEmpty()) {
    //         int size = q.size();
    //         len++;

    //         for(int i=0;i<size;i++) {
    //             String current = q.remove();

    //             for(int j=0;j<current.length();j++) {
    //                 char[] temp = current.toCharArray();
    //                 for(char c='a';c<='z';c++) {
    //                     temp[j]=c;
    //                     String newWord = new String(temp);
    //                     if(newWord.equals(endWord))
    //                         return len+1;
                        
    //                     if(dict.contains(newWord)) {
    //                         q.add(newWord);
    //                         dict.remove(newWord);
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     return 0;
    // }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int len=0;

        while(!q.isEmpty()) {
            int size = q.size();
            len++;
            for(int i=0;i<size;i++) {
                String cur = q.remove();

                for(int j=0;j<cur.length();j++) {
                    char[] temp=cur.toCharArray();

                    for(char c='a';c<='z';c++) {
                        if (c == cur.charAt(j)) continue;
                        temp[j]=c;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord))
                            return len+1;
                        
                        if(set.contains(newWord)) {
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}