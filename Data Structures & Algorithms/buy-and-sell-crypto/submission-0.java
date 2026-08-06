class Solution {
    public int maxProfit(int[] prices) {
        int min = 101, max = 0;
        for(int price : prices){
            min = Math.min(min, price);
            max = Math.max(price - min, max);
        }
        return max; 
    } 
}
