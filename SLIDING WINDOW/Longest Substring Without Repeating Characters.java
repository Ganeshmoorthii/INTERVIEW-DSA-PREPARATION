/*
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen =0;
        HashMap<Character,Integer> map = new HashMap();
        int l =0,r=0,n= s.length();
        while(r<n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                l = Math.max(l,map.get(ch)+1);
            }
            map.put(ch,r);    
            maxLen = Math.max(maxLen,r-l+1);
             r++;
        }
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[256]; // Reset hash for each new starting position
            int curr = 0;
            
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                
                // If character already exists in current substring, break
                if (hash[currentChar] == 1) {
                    break;
                }
                
                // Mark character as seen and update current length
                hash[currentChar] = 1;
                curr = j - i + 1;
                maxLen = Math.max(maxLen, curr);
            }
        }
        
        return maxLen;
    }
}
