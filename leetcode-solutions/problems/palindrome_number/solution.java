class Solution {
    public boolean isPalindrome(int x) {

        if(x<0) return false; 
        int rem=0,q=0;
        int sum=0,x1=x;

        while(x!=0){
            rem=x%10;
            sum=sum*10+rem;
            // System.out.println("sum="+sum, "no="+x)
            x=x/10;
        }

        return sum==x1;
    }
}