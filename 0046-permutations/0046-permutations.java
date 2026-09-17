class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    void findPermutations(int[] nums, List<List<Integer>> result, List<Integer> curList, boolean[] usedVals) {
        if(curList.size() == nums.length){
            result.add(new ArrayList<>(curList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(usedVals[i] == true) continue;
            curList.add(nums[i]);
            usedVals[i] = true;
            findPermutations(nums, result, curList, usedVals);
            curList.remove(curList.size()-1);
            usedVals[i] = false;
        }
    }
}