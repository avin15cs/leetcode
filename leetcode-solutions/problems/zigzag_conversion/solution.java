class Solution {
    // public String convert(String s, int numRows) {
    //     if(numRows == 1)
    //         return s;

    //     List<StringBuilder> rows = new ArrayList<>();
    //     for(int i=0;i<numRows;i++)
    //         rows.add(new StringBuilder());

    //     int i=0;

    //     while(i<s.length()) {

    //         for(int r = 0;r<numRows && i<s.length();r++)
    //             rows.get(r).append(s.charAt(i++));

    //         for(int r = numRows - 2; r>0 && i<s.length();r--)
    //             rows.get(r).append(s.charAt(i++));
    //     }

    //     StringBuilder res = new StringBuilder();
    //     for(StringBuilder row: rows) {
    //         res.append(row);
    //     }

    //     return res.toString();
    // }

    // public String convert(String s, int numRows) {

    //     if (numRows == 1 || s.length() <= numRows) {
    //         return s;
    //     }

    //     StringBuilder[] rows = new StringBuilder[numRows];
    //     for (int i = 0; i < numRows; i++) {
    //         rows[i] = new StringBuilder();
    //     }

    //     int currentRow = 0;
    //     boolean goingDown = true;

    //     for (char ch : s.toCharArray()) {
    //         rows[currentRow].append(ch);

    //         if (currentRow == 0) {
    //             goingDown = true;
    //         } else if (currentRow == numRows - 1) {
    //             goingDown = false;
    //         }

    //         currentRow += goingDown ? 1 : -1;
    //     }

    //     StringBuilder result = new StringBuilder();
    //     for (StringBuilder row : rows) {
    //         result.append(row);
    //     }

    //     return result.toString();
    // }


    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();

        for(int i=0;i<numRows;i++)
            rows.add(new StringBuilder());

        int i=0;
        while(i<s.length()) {

            for(int down = 0;down < numRows && i<s.length();down++)
                rows.get(down).append(s.charAt(i++));
            
            for(int up = numRows-2;up>0 && i<s.length();up--)
                rows.get(up).append(s.charAt(i++));
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb: rows)
            ans.append(sb);
        
        return ans.toString();
    }
}