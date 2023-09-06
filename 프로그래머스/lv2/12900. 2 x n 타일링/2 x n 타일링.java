class Solution {
    
    public int solution(int n) {
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++){
            if(i < 3){
                dp[i] = i%1000000007;
            }else{
                dp[i] = (dp[i-1] + dp[i-2])%1000000007;
            }
        }
        
        return dp[n]%1000000007;
    }
}