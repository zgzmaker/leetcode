class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(k <= 0 || nums == null) return new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : nums)
        {
            if(map.containsKey(i))
            {
                map.put(i, map.get(i)+1);
            }
            else
                map.put(i, 1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(Integer i : map.keySet())
        {
            int frequency = map.get(i);
            if(buckets[frequency] == null)
            {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = buckets.length-1; i >= 0 && res.size() < k; i--)
        {
            if(buckets[i] != null)
            {
                res.addAll(buckets[i]);
            }
        }
        return res;
        
    }
}
