class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean got0 = false, got1 = false, got2 = false;

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            
            if (t[0] == target[0]) got0 = true;
            if (t[1] == target[1]) got1 = true;
            if (t[2] == target[2]) got2 = true;
        }

        return got0 && got1 && got2; 
    }
}