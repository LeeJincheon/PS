class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        int mod = 1000000007;
        
        // 물에 잠긴 지역의 위치
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            map[y][x] = -1;
        }
        
        // 오른쪽과 아래쪽으로만 이동 가능하므로 0행과 0열은 1가지 경로만 존재
        for(int i=1; i<m; i++){
            if(map[0][i] != -1){
                map[0][i] = 1%mod;
            }else{ // 물을 만나면 그 뒤는 갈 수 없음
                break;
            }
        }
        for(int i=1; i<n; i++){
            if(map[i][0] != -1){
                map[i][0] = 1%mod;
            }else{ // 물을 만나면 그 아래는 갈 수 없음
                break;
            }
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(map[i][j] != -1){
                    if(map[i-1][j] == -1){ // 위쪽이 물인 경우
                        map[i][j] = map[i][j-1]%mod;
                    }else if(map[i][j-1] == -1){ // 왼쪽이 물인 경우
                        map[i][j] = map[i-1][j]%mod;
                    }else if(map[i-1][j]==-1 && map[i][j-1]==-1){ // 둘 다 물인 경우
                        map[i][j] = 0;
                    }else{ // 둘 다 물이 아닌 경우
                        map[i][j] = (map[i-1][j] + map[i][j-1])%mod;
                    }
                }
            }
        }
        
        return map[n-1][m-1]%1000000007;
    }
}