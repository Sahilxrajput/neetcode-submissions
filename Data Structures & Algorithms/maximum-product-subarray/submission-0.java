class Solution {
    public int maxProduct(int[] nums) {
        // bhai dimag kharab ho gya is question ke peeche 
        int n =nums.length;
        int prefix = 0, suffix =0;
        int max = Integer. MIN_VALUE;

        for(int i=0; i<n; i++){
            if(prefix==0) prefix =1;
            if(suffix==0) suffix =1;

            prefix*=nums[i];
            suffix*=nums[n-i-1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
