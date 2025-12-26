class MinStack {
    List<Integer> list;
    int min=Integer.MAX_VALUE;
    public MinStack() {
        list=new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        min=Math.min(min,val);
        list.add(min);
    }
    
    public void pop() {
        list.remove(list.size()-1);
        list.remove(list.size()-1);

        if (!list.isEmpty()) {
            min = list.get(list.size() - 1);
        } else {
            min = Integer.MAX_VALUE; 
        }
    }
    
    public int top() {
        return list.get(list.size()-2);
        
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