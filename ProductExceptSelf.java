class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] Left = new int[nums.length];
       int[] Right = new int[nums.length];

       Left[0]=1;
       for(int i =1; i<nums.length;i++){
        Left[i] = Left[i-1]*nums[i-1];
       }

       Right[nums.length-1] = 1;
       for(int i = nums.length-2;i>-1 ;i--){
        Right[i]=Right[i+1]*nums[i+1];
       }

       int [] ans = new int[nums.length];
       for(int i =0;i<nums.length;i++){
        ans[i] = Left[i]*Right[i];
       }
        return ans;
    }
}
