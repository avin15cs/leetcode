class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        if(n%2!=0)
            return -1;

        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minH = new PriorityQueue<>();

        int k=n/2;

        for(int i: skill) {
            maxH.add(i);
            minH.add(i);

            if(minH.size()>k)
                minH.remove();
            
            if(maxH.size()>k)
                maxH.remove();
        }

        int max = maxH.remove();
        int min = minH.remove();
        int sum=max+min;
        long prodSum = max*min;

        while(maxH.size()>0) {
            max = maxH.remove();
            min = minH.remove();
            int cursum=max+min;
            if(sum!=cursum)
                return -1;
            prodSum = prodSum+max*min;

        }

        return prodSum;
    }
}