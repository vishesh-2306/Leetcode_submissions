class Solution {
    private boolean solve(String s, String pattern) {
        int p = 0;

        for (int i = 0; i < s.length(); i++) {
            char qc = s.charAt(i);

            if (p < pattern.length() && qc == pattern.charAt(p)) {
                p++;
            } else if (Character.isUpperCase(qc)) {
                return false;
            }
        }

        return p == pattern.length();
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            ans.add(solve(q, pattern));
        }

        return ans;
    }
}