class Solution {
    public boolean searchInRow(int[][] matrix, int target,int row){
        int m=matrix.length;
        int n=matrix[0].length;
        int start=0;
        int ending=n-1;
        while(start<=ending){
            int mid=start+(ending-start)/2;
            if(target==matrix[row][mid]){
                return true;
            }
            else if(target>matrix[row][mid]){
                start=mid+1;

            }
            else{
                ending=mid-1;
            }
        }
        return false;

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n= matrix[0].length;
        int st=0;
        int end=m-1;
        while(st<=end){
            int midRow=st+(end-st)/2;
            if(target>=matrix[midRow][0]&& target<=matrix[midRow][n-1]){
                return searchInRow(matrix,target,midRow);
            }
            else if(target>=matrix[midRow][n-1]){
                st=midRow+1;
            }
            else{
                end=midRow-1;
            }
        }
        return false;
        
    }
}