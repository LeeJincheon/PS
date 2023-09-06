class Solution {
    public long solution(int n) {
        
        long[] dp = new long[n+1];
        for(int i=1; i<=n; i++){
            if(i < 3){
                dp[i] = i%1234567;
            }else{
                dp[i] = (dp[i-1] + dp[i-2])%1234567;
            }
        }
        
        return dp[n]%1234567;
    }
}