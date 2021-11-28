class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
//         int len=nums.length;
//         int curSum=0,min=Integer.MAX_VALUE;
//         HashMap<Integer,Integer> map=new HashMap<>();
//         map.put(0,0);
//         for(int i=0;i<len;i++){
//             curSum+=nums[i];
//             if(map.containsKey(curSum-target)){
//                 if(curSum-target==0)
//                     return i+1;
                
//                 int x=i-map.get(curSum-target)+1;
//                 if(min>x)
//                     min=x;
//             }
//             map.put(curSum,i+1);
//         }
//         if(min==Integer.MAX_VALUE)
//             return 0;
//         return min;
        
        int minlen = Integer.MAX_VALUE;
		int curSum = 0;
		int start = 0;
		int end = 0;
		
		while(start < nums.length){
			//if current window doesn't add up to the given sum then 
			//strech the window to right
			if(curSum < target && end < nums.length){
				curSum += nums[end];
				end++;
			}
			//if current window adds up to at least given sum then
			//we can shrink the window 
			else if(curSum >= target){
				minlen = Math.min(minlen, end-start);
				curSum -= nums[start];
				start++;
			}
			//cur sum less than required sum but we reach the end 
			else{
				break;
			}
		}
		
		return (minlen == Integer.MAX_VALUE) ? 0 : minlen;
    }
}