class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums=new Stack<>();
        int a,b;
        for(String token: tokens) {
            if(token.equals("+")) {
                nums.add(nums.pop()+nums.pop());
            } else if(token.equals("*")) {
                nums.add(nums.pop()*nums.pop());
            } else if(token.equals("/")) {
                b=nums.pop();
                a=nums.pop();
                nums.add(a/b); 
            } else if(token.equals("-")) {
                b=nums.pop();
                a=nums.pop();
                nums.add(a-b);
            } else {
                nums.add(Integer.parseInt(token));
            }
        }

        return nums.pop();
    }
}