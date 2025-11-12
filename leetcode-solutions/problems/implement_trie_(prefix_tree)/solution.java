class Node {

    Node[] links;
    boolean flag;
    public Node() {
        links=new Node[26];
    }

    boolean containsKey(char c) {
        return links[c-'a']!=null;
    }

    Node get(char c) {
        return links[c-'a'];
    }

    void add(char c, Node node) {
        links[c-'a'] = node;
    }

    boolean isEnd() {
        return flag==true;
    }

}

class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++) {
            char c=word.charAt(i);
            if(!node.containsKey(c)) {
                node.add(c,new Node());
            }
            node=node.get(c);
        }
        node.flag=true;
    }
    
    public boolean search(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++) {
            char c=word.charAt(i);
            if(!node.containsKey(c)) {
                return false;
            }
            node=node.get(c);
        }

        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i=0;i<prefix.length();i++) {
            char c=prefix.charAt(i);
            if(!node.containsKey(c)) {
                return false;
            }
            node=node.get(c);
        }

        return true;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */