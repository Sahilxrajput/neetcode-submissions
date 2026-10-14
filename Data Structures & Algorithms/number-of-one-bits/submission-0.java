class Solution {
    public int hammingWeight(int num) {
        int cnt =0;

        while(num>0){
            cnt += num & 1;
            num >>= 1;
        }
        return cnt;
    }
}
