class Solution {
    public int countArrays(int[] digitSum) {
        int n = digitSum.length;
        int mod = 1000000007;
        int max = 5000;
        int sum[] = new int[max + 1];
        for(int i =0;i<=max;i++){
            int temp = i;
            int s = 0;
            while(temp>0){
                s += temp % 10;
                temp /=10;
            }
            sum[i]=s;
        }
        int dp[] = new int[max +1];
        for(int i =0;i <= max; i++){
            if(sum[i] == digitSum[0]) dp[i]=1;

        }
        for(int i =1;i<n;i++){
            int next[] = new int [max + 1];
            long pref = 0;

            for(int j =0; j<= max;j++){
                pref = (pref + dp[j])%mod;
                if(sum[j] == digitSum[i]){
                    next[j] = (int)pref;
                }
            }
            dp = next;
        }
        long ans = 0;
        for(int i =0;i <= max; i++){
            ans =(ans +dp[i])%mod;
        }
        return(int)ans;
    }
}