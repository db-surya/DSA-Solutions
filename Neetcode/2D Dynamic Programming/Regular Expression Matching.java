class Solution {
    public boolean wildCardMatch(char[] s, char[] p, int i, int j, Boolean[][] memo) {
        if (i < 0 && j < 0)
            return true;
        if (j < 0)
            return false;
        if (i < 0) {
            while (j >= 0 && p[j] == '*') {
                j -= 2;
            }
            return j < 0;
        }
        if (memo[i][j] != null)
            return memo[i][j];
        boolean result = false;
        if (s[i] == p[j] || p[j] == '.') {
            result = wildCardMatch(s, p, i - 1, j - 1, memo);
        } else if (p[j] == '*') {
            result = wildCardMatch(s, p, i, j - 2, memo);
            if (p[j - 1] == s[i] || p[j - 1] == '.') {
                result = result || wildCardMatch(s, p, i - 1, j, memo);
            }
        }
        return memo[i][j] = result;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()][p.length()];
        return wildCardMatch(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1, memo);
    }
}