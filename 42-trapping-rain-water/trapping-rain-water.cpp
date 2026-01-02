class Solution {
public:
    int trap(vector<int>& height) {
        int n=height.size();
        int ans=0;
        int l=0, r=n-1;
        int lMax=0,rMax=0;
        while(l<r){
            lMax=max(lMax,height[l]);
            rMax=max(rMax,height[r]);
            if(lMax<rMax){
                ans+=(lMax-height[l]);
                l++;
            }
            else{
                ans+=(rMax-height[r]);
                r--;
            }
        }
        return ans;
        
    }
};