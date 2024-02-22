class Solution {
    
    static int answer;
    
    static void dfs(int[]numbers, int target, int level, int sum) {
        if (level == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, level+1, sum+numbers[level]);
        dfs(numbers, target, level+1, sum-numbers[level]);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
}