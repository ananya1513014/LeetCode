class Solution {
    
    static boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        if(grid.length==0)  return 0;
        visited = new boolean[grid.length][grid[0].length];
        initArr(visited);
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++){
                if(visited[i][j])  continue;
                else{
                    
                    if(grid[i][j]=='0') {
                        visited[i][j] = true;
                    } else{
                        roam(i, j, grid);
                        count++;
                    }                    
                }
            }            
        }
        return count;
    }
    
    public static void initArr(boolean[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = false;
            }
        }
    }
    
    public static void roam(int x, int y, char[][]arr){
     
        if(x<0||x>=arr.length||y<0||y>=arr[0].length)   return;
        
        if(visited[x][y])   return;
        
        visited[x][y] = true;
        
        if(arr[x][y]=='1') {
        roam(x+1, y, arr);
        roam(x, y+1, arr);
        roam(x-1, y, arr);
        roam(x, y-1, arr);  
        }
        return;
    }    
}
