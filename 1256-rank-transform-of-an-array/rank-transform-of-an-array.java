class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] newA = arr.clone();
        Arrays.sort(newA);
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int rank=1;
        for(int i=0;i<n;i++) {
            if(!map.containsKey(newA[i]))
                map.put(newA[i],rank++);
        }
        
        int[] result = new int[n];
        
        for(int i=0;i<n;i++)
            result[i] = map.get(arr[i]);
        
        return result;
    }
}