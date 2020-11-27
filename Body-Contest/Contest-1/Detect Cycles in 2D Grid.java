class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] seen = new int[n][m];
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(dfs(grid, r, c, -1, -1, true, seen)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] grid, int r, int c, int p_r, int p_c, boolean start, int[][] seen) {
        int n = grid.length, m = grid[0].length;
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        
        for(int[] direct : directions){
            int _r = r + direct[0];
            int _c = c + direct[1];
            
            if(_r < 0 || _r >= n || _c < 0 || _c >= m || grid[_r][_c] != grid[r][c]){
                continue;
            }
            
            if(seen[_r][_c] == 1){
                if(!start && _r != p_r && _c != p_c){
                    return true;
                }
                
                continue;
            }
            
            seen[_r][_c] = 1;
            if(dfs(grid, _r, _c, r, c, false, seen)){
                return true;
            }
        }
        
        return false;
    }
}