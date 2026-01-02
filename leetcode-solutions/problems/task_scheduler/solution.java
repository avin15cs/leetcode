class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char c: tasks) 
            freq[c-'A']++;

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<26;i++) {
            if(freq[i]>0)
                pq.add(freq[i]);
        }
            

        int time=0;
        while(!pq.isEmpty()) {
            int cycle = n+1;
            List<Integer> list = new ArrayList<>();

            while(cycle>0 && !pq.isEmpty()) {
                int cur = pq.poll();
                cur--;
                if(cur>0)
                    list.add(cur);
                cycle--;
                time++;
            }

            for(int num: list)
                pq.add(num);
            
            if(!pq.isEmpty())
                time+=cycle;
        } 

        return time;
    }
}