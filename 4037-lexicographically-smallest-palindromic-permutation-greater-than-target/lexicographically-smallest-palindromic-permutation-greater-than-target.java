class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

       
        int oddCount = 0;
        int oddChar = -1;
        for (int c = 0; c < 26; c++) {
            if (count[c] % 2 != 0) {
                oddCount++;
                oddChar = c;
            }
        }
        if (oddCount > 1) {
            return "";
        }

        
        int[] halfCount = new int[26];
        for (int c = 0; c < 26; c++) {
            halfCount[c] = count[c] / 2;
        }

        int m = n / 2;

        
        int[] tempHalf = halfCount.clone();
        int matchLen = 0;
        while (matchLen < m) {
            int ch = target.charAt(matchLen) - 'a';
            if (tempHalf[ch] > 0) {
                tempHalf[ch]--;
                matchLen++;
            } else {
                break;
            }
        }

        // Candidate 1: The first half matches target[0...m-1] completely
        String candidateExact = null;
        if (matchLen == m) {
            String fullPal = buildPalindrome(target.substring(0, m), oddChar, n % 2 != 0);
            if (fullPal.compareTo(target) > 0) {
                candidateExact = fullPal;
            }
        }

        
        String candidateDiverged = null;
        for (int i = matchLen; i >= 0; i--) {
            if (i == m) continue;

            
            int[] currentHalf = halfCount.clone();
            for (int j = 0; j < i; j++) {
                currentHalf[target.charAt(j) - 'a']--;
            }

            int targetChar = target.charAt(i) - 'a';
            int chosenChar = -1;

            
            for (int c = targetChar + 1; c < 26; c++) {
                if (currentHalf[c] > 0) {
                    chosenChar = c;
                    break;
                }
            }

            if (chosenChar != -1) {
                StringBuilder firstHalf = new StringBuilder();
                firstHalf.append(target, 0, i);
                firstHalf.append((char) ('a' + chosenChar));
                currentHalf[chosenChar]--;

                
                for (int c = 0; c < 26; c++) {
                    while (currentHalf[c] > 0) {
                        firstHalf.append((char) ('a' + c));
                        currentHalf[c]--;
                    }
                }

                candidateDiverged = buildPalindrome(firstHalf.toString(), oddChar, n % 2 != 0);
                break; 
            }
        }

        
        if (candidateExact == null && candidateDiverged == null) {
            return "";
        }
        if (candidateExact != null && candidateDiverged != null) {
            return candidateExact.compareTo(candidateDiverged) < 0 ? candidateExact : candidateDiverged;
        }
        return candidateExact != null ? candidateExact : candidateDiverged;
    }

    private String buildPalindrome(String firstHalf, int oddChar, boolean isOdd) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (isOdd) {
            sb.append((char) ('a' + oddChar));
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}