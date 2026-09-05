class Solution {
    private void generate(int n, int open, int close,StringBuilder ds,List<String>ans){
        if(ds.length() == 2*n){
            ans.add(ds.toString());
            return;
        }

        if(open<n){
            ds.append('(');
            generate(n,open+1,close,ds,ans);
            ds.deleteCharAt(ds.length()-1);
        }
        if(close<open){
            ds.append(')');
            generate(n,open,close+1,ds,ans);
            ds.deleteCharAt(ds.length()-1);
        }
    }


    public List<String> generateParenthesis(int n) {
     List<String> ans = new ArrayList<>();
     StringBuilder  ds = new StringBuilder();
     generate(n,0,0,ds,ans);
     return ans;
    }
}