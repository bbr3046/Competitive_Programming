class Solution {

    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp,-1);
        int ans = 0;
        for(int length = high;length >= low; length--){
             if(dp[length] != -1){
                ans = (ans+dp[length])%1000000007;
                continue;
             }
             ans += f(length,zero,one,dp)%1000000007;
        }
        // for(int num: dp)
        //     System.out.print(num+"#");
        return ans;

        
    }

    public int f(int n,int zero, int one,int[] dp){
        if(n<0) return 0;
        if(n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = (f(n-zero,zero,one,dp) + f(n-one,zero,one,dp))%1000000007;
        return dp[n];
    }
}
