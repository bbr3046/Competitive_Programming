class Solution {
    List<List<String>> result =new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = null;
        board = fillBoard(board,n);
        f(board,0);
        return result;
    }

    public void f(List<String> board,int col){
        if(col == board.size()){
              result.add(copyList(board));
            //   for(int i =0;i<board.size();i++){
            //      for(int j =0;j<board.size();j++)
            //        System.out.print(board.get(i).charAt(j)+" ");
            //      System.out.println();
            //     }
              return;
        }
        for(int row =0;row<board.size();row++){
             if(isValidPlace(board,row,col)){
                 String s = board.get(row);
                 StringBuilder sb = new StringBuilder(s);
                 sb.setCharAt(col,'Q');
                 String ss = sb.toString();
                 board.set(row,ss);
                 f(board,col+1);
                 board.set(row,s);
             }
                
        }
    }

    public List<String> fillBoard(List<String> board,int n){
        board = new ArrayList<>();
        for(int i=0;i<n;i++){
            String temp = "";
            for(int j=0;j<n;j++)
              temp+=".";
            board.add(temp);
        }
       return board;
    }

    public boolean isValidPlace(List<String> board, int row, int col){
        int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};
        for(int[] delta :deltas){
            int x = row;
            int y = col;
            while (x+delta[0] >= 0 && x+delta[0] < board.size() && delta[1]+y >=0 && delta[1]+y <board.size()){
                x += delta[0];
                y += delta[1];
                if(board.get(x).charAt(y) == 'Q') return false;
            }

        }
        return true;
    }

    // for copying the board since the board keeps changing and comes back to original state
    // we have to copy the state of  the board at the final state.
    public List<String> copyList(List<String> board){
        List<String> b = new ArrayList<>();
        for(String s: board)
           b.add(s);
        return b;
    }
}
