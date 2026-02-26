class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words= s.split("\\s+");
        int i=0,j=words.length-1;
        while(i<j){
            String temp=words[i];
            words[i]=words[j];
            words[j]=temp;
            i++;
            j--;
        }
        return String.join(" ",words);

    }
    // public String reverseWords(String s) {
    //     StringBuilder str = new StringBuilder(s);
    //     str.reverse(); //reverse entire String
    //     int n= s.length();
        
    //     String ans="";

    //     for(int i=0;i<n;i++){
    //         StringBuilder word = new StringBuilder();

    //         //Extract word
    //         while(i<n && str.charAt(i)!=' '){
    //             word.append(str.charAt(i));
    //             i++;
    //         }

    //         //step 3: Reverse word and append if not empty
    //         if(word.length()>0) {
    //             word.reverse();
    //             ans +=" " + word.toString();
    //         }

    //     }
    //     return ans.trim();
    // }
}