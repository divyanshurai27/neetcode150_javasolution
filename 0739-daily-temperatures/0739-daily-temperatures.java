class Solution {
    public int[] dailyTemperatures(int[] t) {
    
       int res[] = new int[t.length] ;
        Stack<Integer> st = new Stack<>();
     for(int i=0;i<t.length;i++){
        while(!st.isEmpty() && t[st.peek()] < t[i] ){
          Integer pop  = st.pop();
          res[pop] = i - pop;
        } st.push(i);
    }return res;
    }
}