class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length())
            return res;

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int have = 0;
        int required = 0;

        for (int x : need) {
            if (x > 0) required++;
        }

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r) - 'a';
            window[c]++;

            if (window[c] == need[c]) {
                have++;
            }

            while (r - l + 1 > p.length()) {
                int left = s.charAt(l) - 'a';

                if (window[left] == need[left]) {
                    have--;
                }

                window[left]--;
                l++;
            }

            if (r - l + 1 == p.length() && have == required) {
                res.add(l);
            }
        }

        return res;
    }
}