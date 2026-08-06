class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length, l=0, r=n-1;
        int maxi = -1;

        while(l<r){
            int height = Math.min(heights[r], heights[l]);
            maxi = Math.max(maxi, height * (r-l));
            if(heights[l]>heights[r]) 
                r--;
            else
                l++;
        }
        return maxi;
    }
}
