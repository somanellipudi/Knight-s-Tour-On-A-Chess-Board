    /*
     * Complete the function below.
     */
    static int find_number_of_reaches(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.
        
        int result = 0;
        
        //base case
        if(start_row == end_row && start_col == end_col){
            return result;
        }
        
        
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] visited = new boolean[rows][cols];
        
        q.add(new int[] {start_row, start_col});
        int[][] dir = { {1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
        
        visited[start_row][start_col] = true;
        
        while(!q.isEmpty()){
            
            int[] node = q.remove();
            
            visited[node[0]][node[1]] = true;
            
            if(node[0] == end_row && node[1] == end_col){
                result++;
            }
            
            for(int j=0; j<= dir.length-1; j++){
                int next_row = node[0] + dir[j][0];
                int next_col = node[1] + dir[j][1];
                
                if(next_row >= 0 && next_col >= 0 && next_row <= rows-1 && next_col <= cols-1  && visited[next_row][next_col] != true){
                    q.add(new int[] {next_row, next_col});
                }
            }
        }
        
        if(result == 0){
            return -1;
        }
        
        return result;


    }

