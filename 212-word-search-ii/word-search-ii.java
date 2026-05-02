class Solution {
    // public List<String> findWords(char[][] board, String[] words) {
    //     Set<String> list = new HashSet<>();
    //     for(int i=0;i<board.length;i++) {
    //         for(int j=0;j<board[0].length;j++) {
    //             for(String word: words) {

    //                 if(exists(board,word,i,j,0))
    //                     list.add(word);
    //             }
    //         }
    //     }
    //     return new ArrayList<>(list);
    // }

    // boolean exists(char[][] board, String word, int r, int c, int idx) {
    //     if(idx==word.length())
    //         return true;

    //     if(r<0||c<0||r==board.length||c==board[0].length||board[r][c]!=word.charAt(idx))
    //         return false;

    //     board[r][c]='*';

    //     boolean result = exists(board, word, r+1, c, idx+1)||
    //                     exists(board, word, r-1, c, idx+1)||
    //                     exists(board, word, r, c-1, idx+1)||
    //                     exists(board, word, r, c+1, idx+1);

    //     board[r][c]=word.charAt(idx);

    //     return result;
    // }

    // public List<String> findWords(char[][] board, String[] words) {
    //     TrieNode root = buildTrie(words);
    //     List<String> list = new ArrayList<>();
    //     for(int i=0;i<board.length;i++) {
    //         for(int j=0;j<board[0].length;j++) {
    //             dfs(board, i, j, root, list);
    //         }
    //     }
    //     return list;
    // }

    // TrieNode buildTrie(String[] words) {
    //     TrieNode root = new TrieNode();
    //     for(String word: words) {
    //         TrieNode cur = root;
    //         for(char c: word.toCharArray()) {
    //             int idx = c-'a';
    //             if(cur.children[idx]==null)
    //                 cur.children[idx]=new TrieNode();
    //             cur = cur.children[idx];
    //         }

    //         cur.word = word;
    //     }

    //     return root;
    // }

    // void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
    //     if(r<0||c<0||r==board.length||c==board[0].length)
    //         return;
        
    //     char ch = board[r][c];
    //     if(ch=='#'||node.children[ch-'a']==null)
    //         return;

    //     node = node.children[ch-'a'];
    //     if(node.word!=null) {
    //         result.add(node.word);
    //         node.word = null;
    //     }

    //     board[r][c]='#';
    //     dfs(board, r+1, c, node, result);
    //     dfs(board, r-1, c, node, result);
    //     dfs(board, r, c+1, node, result);
    //     dfs(board, r, c-1, node, result);

    //     board[r][c]=ch;
    // }

    // class TrieNode {
    //     TrieNode[] children = new TrieNode[26];
    //     String word;
    // }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board, root, i, j, list);
            }
        }
        return list;
    }

    void dfs(char[][] board, TrieNode root, int i, int j, List<String> list) {
        if(i<0||j<0||i>=board.length||j>=board[0].length)
            return;
        char ch = board[i][j];
        if(ch=='#'||root.children[ch-'a']==null)
            return;

        root = root.children[ch-'a'];

        if(root.word!=null) {
            list.add(root.word);
            root.word=null;
        }

        board[i][j] = '#';
        dfs(board, root, i+1, j, list);
        dfs(board, root, i-1, j, list);
        dfs(board, root, i, j+1, list);
        dfs(board, root, i, j-1, list);

        board[i][j]=ch;
    }
    
    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode trie = root;
            for(char c: word.toCharArray()) {
                int idx = c-'a';
                if(trie.children[idx]==null)
                    trie.children[idx] = new TrieNode();
                trie=trie.children[idx];
            }

            trie.word = word;
        }

        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}