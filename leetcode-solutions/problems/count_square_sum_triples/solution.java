class Solution {
    public int countTriples(int n) {
        
        int c = 0;
        for(int i=1;i<=n;i++)
        {
            int c2 = i * i;
            int a = 1, b = i;
            while(a <= b)
            {
                int a2 = a * a;
                int b2 = b * b;
                if(a2 + b2 < c2)
                    a++;
                else if(a2 + b2 > c2)
                    b--;
                else
                {
                    c+=2;
                    a++;
                    b--;
                }
            }
        }
        return c;
    }
}