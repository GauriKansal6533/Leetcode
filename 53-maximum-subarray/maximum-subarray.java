class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxi=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0; i<n; i++){
            currSum+=nums[i];
            maxi=Math.max(maxi,currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return maxi;
        
    }
}