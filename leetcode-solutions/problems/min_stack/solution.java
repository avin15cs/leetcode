class MinStack {
    List<Integer> list;
    int min=Integer.MAX_VALUE;
    public MinStack() {
        list=new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        min=Math.min(min,val);
    }
    
    public void pop() {
        int num=list.remove(list.size()-1);
        int i=0;
        if(min==num) {
            min=Integer.MAX_VALUE;
            while(i<list.size()) {
                min=Math.min(min,list.get(i++));
            }
        }

    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */