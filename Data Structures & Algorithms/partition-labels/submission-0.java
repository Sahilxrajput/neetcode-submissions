class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); ++i){
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); ++i){
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // If our current index reaches that required end boundary, the partition is complete
            if (i == end) {
                list.add(end - start + 1);
                start = i + 1;
            }
        }

        return list;
    }
}