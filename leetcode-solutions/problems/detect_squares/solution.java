class DetectSquares {

    List<int[]> list;
    Map<String, Integer> map;

    public DetectSquares() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        list.add(point);
        String s = point[0]+","+point[1];
        map.put(s,map.getOrDefault(s,0)+1);
    }
    
    public int count(int[] point) {
        int px=point[0];
        int py=point[1];

        int res=0;

        for(int[] p: list) {
            int x=p[0];
            int y=p[1];
            if(x==px || y==py || Math.abs(px-x)!=Math.abs(py-y))
                continue;
            
            res+=map.getOrDefault(x+","+py,0)*map.getOrDefault(px+","+y,0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */