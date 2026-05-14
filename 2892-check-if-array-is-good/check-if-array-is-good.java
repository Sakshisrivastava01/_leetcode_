class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        Set<Integer> good = new HashSet<>();
        boolean dupplicate = false;
        for (int num : nums) {
            if (num > n) return false;
            if (good.contains(num)) {
                if (num < n || dupplicate) return false;
                dupplicate = true;
                continue;
            }
            good.add(num);
        }

        return true;
    }
}