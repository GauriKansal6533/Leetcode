class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        
        vector<vector<int>> ans;
        for(int i=1;i<=numRows;i++){
            vector<int> ansRow;
        long long val=1;
        for(int col=1;col<=i;col++){
            ansRow.push_back(val);
            val=val*(i-col)/col;
        }
        ans.push_back(ansRow);
        }
        return ans;
        
    }
};