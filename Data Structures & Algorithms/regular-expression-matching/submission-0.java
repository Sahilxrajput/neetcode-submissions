class Solution {
    Boolean[][] dp;
    
    private boolean fn(int i, int j, String s, String p) {
        if (i < 0 && j < 0) return true;
        
        if (j < 0) return false;
        
        if (i < 0) {
            if (p.charAt(j) == '*') {
                return fn(i, j - 2, s, p); // Skip the '*' and its preceding character
            }
            return false;
        }
        
        if (dp[i][j] != null) return dp[i][j];
        
        boolean match = false;
        
        if (p.charAt(j) == '*') {
            boolean ignore = fn(i, j - 2, s, p);
            
            boolean use = false;
            if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                use = fn(i - 1, j, s, p); 
            }
            
            match = ignore || use;
            
        } 
        else if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
            match = fn(i - 1, j - 1, s, p);
        }
        
        return dp[i][j] = match;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        dp = new Boolean[n][m];
        
        return fn(n - 1, m - 1, s, p);
    }
}