class WordDictionary {
    private WordDictionary[] children;
    boolean isEndOfWord;
    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord=false;
    }
    
    public void addWord(String word) {
        WordDictionary cur=this;
        for(char c: word.toCharArray()) {
            if(cur.children[c-'a']==null) {
                cur.children[c-'a']=new WordDictionary();
            }

            cur=cur.children[c-'a'];
        }

        cur.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        WordDictionary cur=this;

        for(int i=0;i<word.length();i++) {
            char c=word.charAt(i);
            if(c == '.') {
                for(WordDictionary ch: cur.children)
                    if(ch != null && ch.search(word.substring(i+1))) return true;
                return false;
            }

            if(cur.children[c-'a']==null)
                return false;
            
            cur=cur.children[c-'a'];
        }
        return cur!=null && cur.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */