class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low=0;
        int high=letters.length-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(target<letters[mid])
                high=mid-1;
            
            // else if(target>letters[mid])
            else
                low=mid+1;
            
            // else
            //     return letters[(mid+1)%letters.length];
        }
        
        return letters[low%letters.length];
        
    }
}