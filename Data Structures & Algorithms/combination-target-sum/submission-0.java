class Solution {
    List<List<Integer>> list;

    void backtrack(int ind, int[] nums, int tar, List<Integer> cur){
        if(tar == 0){
            list.add(new ArrayList<>(cur));
            return;
        }
        
        if(tar < 0 || ind == nums.length) {
            return;
        }

        if(nums[ind] <= tar){
            cur.add(nums[ind]);
            backtrack(ind, nums, tar - nums[ind], cur);
            cur.remove(cur.size() - 1); 
        }
        
        backtrack(ind + 1, nums, tar, cur);
    }
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        list = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>());
        return list;
    }
}