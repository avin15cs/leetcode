class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int orgcolor=image[sr][sc];
        if(orgcolor==newcolor)    
            return image;
        
        fill(image,sr,sc,orgcolor,newcolor);
        return image;
    }

    void fill(int[][] image, int row, int col, int orgcolor, int newcolor) {
        if(row<0||col<0||row>=image.length||col>=image[0].length)
            return;
        
        if(image[row][col]!=orgcolor)
            return;

        image[row][col]=newcolor;

        fill(image,row+1,col,orgcolor,newcolor);
        fill(image,row-1,col,orgcolor,newcolor);
        fill(image,row,col+1,orgcolor,newcolor);
        fill(image,row,col-1,orgcolor,newcolor);
    }
}