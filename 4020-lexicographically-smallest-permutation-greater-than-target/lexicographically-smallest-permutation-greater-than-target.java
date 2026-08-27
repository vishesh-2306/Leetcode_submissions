class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        
        int[] prefixCount = Arrays.copyOf(count, 26);
        int matchLen = 0;
        
        while (matchLen < n) {
            int charIdx = target.charAt(matchLen) - 'a';
            if (prefixCount[charIdx] > 0) {
                prefixCount[charIdx]--;
                matchLen++;
            } else {
                break;
            }
        }
        
        
        for (int i = matchLen; i >= 0; i--) {
            
            if (i == n) continue;
            
            
            int[] currentCount = Arrays.copyOf(count, 26);
            for (int j = 0; j < i; j++) {
                currentCount[target.charAt(j) - 'a']--;
            }
            
            int targetChar = target.charAt(i) - 'a';
            int chosenChar = -1;
            
            
            for (int c = targetChar + 1; c < 26; c++) {
                if (currentCount[c] > 0) {
                    chosenChar = c;
                    break;
                }
            }
            
            
            if (chosenChar != -1) {
                StringBuilder result = new StringBuilder();
                
                
                result.append(target.substring(0, i));
                
                
                result.append((char) ('a' + chosenChar));
                currentCount[chosenChar]--;
                
                
                for (int c = 0; c < 26; c++) {
                    while (currentCount[c] > 0) {
                        result.append((char) ('a' + c));
                        currentCount[c]--;
                    }
                }
                
                return result.toString();
            }
        }
        
        return "";
    }
}


    