class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        if(n%2!=0)
            return -1;

        Arrays.sort(skill);

        int i=0,j=n-1;

        int target = skill[i]+skill[j];
        long prodSum=0;
        while(i<j) {
            if(target!=skill[i]+skill[j])
                return -1;

            prodSum+=skill[i]*skill[j];

            i++;
            j--;
        }

        return prodSum;

    }
}