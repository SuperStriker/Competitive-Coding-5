
TC: O(m*n)
SC: O(3*m*n)

504 / 504 test cases passed.
Status: Accepted
Runtime: 10 ms
Memory Usage: 44.4 MB
Submitted: 1 hour, 13 minutes ago

Approach: I will save all elements with row index,column index, and the position of the box (9 boxes from 00,01,02 to 22)
in a hashset, and check for new elements whether it is already there.The number 10 is used to check for row and column separately becoz 10 cannot come
as a row or column.

class Solution {
    public boolean isValidSudoku(char[][] board) {
      Set<List<Integer>> hash = new HashSet<>();
        for(int i=0 ; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j]!= '.'){
                    List<Integer> l1= new ArrayList<>();
                    l1.addAll(Arrays.asList(board[i][j]-'0',i,10));
                    List<Integer> l2= new ArrayList<>();
                    l2.addAll(Arrays.asList(board[i][j]-'0',10,j));
                    List<Integer> l3= new ArrayList<>();
                    l3.addAll(Arrays.asList(board[i][j]-'0',i/3,j/3));
                    
                    if(hash.contains(l1)|| hash.contains(l2) || hash.contains(l3)){
                        return false;
                    }else{
                       hash.add(l1);
                       hash.add(l2);
                       hash.add(l3);
                    }
                
                }
            }
        }
            
        return true;
    }
}
