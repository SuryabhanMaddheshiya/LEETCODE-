class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i,1);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        LinkedList<Integer> ls=new LinkedList<>();
        permu2(hm,ans,ls,nums.length);
        return ans;
    }
    void permu2(HashMap<Integer,Integer> hm,List<List<Integer>> ans,LinkedList<Integer> ls,int len){
        if(ls.size()==len){
            ans.add(new ArrayList<Integer>(ls));
            return;
        }
        Set<Integer> ks=hm.keySet();
        List<Integer> arr=new ArrayList<>(ks);

        for(int i:arr){
            if(hm.get(i)==0) continue;

            hm.put(i,hm.get(i)-1);
            ls.addLast(i);
            permu2(hm,ans,ls,len); 
            hm.put(i,hm.get(i)+1);
            ls.removeLast();

        }
    }
}