class Solution {
    public int minMoves(int[] nums, int l) {
        int n=nums.length, min, max;
        int[] c = new int[2*l+2];
        for(int i=0; i<n/2; i++){
            min=Math.min(nums[i],nums[n-1-i])+1;
            max=Math.max(nums[i],nums[n-1-i])+l;
            c[min]--;
            c[max+1]++;
            c[nums[i]+nums[n-1-i]]--;
            c[nums[i]+nums[n-1-i]+1]++;
        }
        int a=n, x=n;
        for(int i=2; i<=2*l; i++){
            x+=c[i];
            if(a>x)a=x;
        }
        return a;  
    }
}