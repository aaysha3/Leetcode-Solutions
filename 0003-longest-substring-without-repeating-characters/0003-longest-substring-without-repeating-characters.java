class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;
        int[] freq = new int[128];
        
        while (right < n) {
            char c = s.charAt(right);
            freq[c]++;
            
            while (freq[c] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        
        return maxLen;
    }
}
