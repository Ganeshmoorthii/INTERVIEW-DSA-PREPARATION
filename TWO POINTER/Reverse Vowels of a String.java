/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/

class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int l=0,r=s.length()-1;
        String vow = "AEIOUaeiou";
        StringBuilder sb = new StringBuilder(s);
        while(l<r){
            char left = sb.charAt(l);
            char right = sb.charAt(r);

            // move left pointer until vowel
            if (!vow.contains(String.valueOf(left))) {
                l++;
                continue;
            }

            // move right pointer until vowel
            if (!vow.contains(String.valueOf(right))) {
                r--;
                continue;
            }

            // swap vowels
            sb.setCharAt(l, right);
            sb.setCharAt(r, left);

            l++;
            r--;
        }
        return sb.toString();
    }
}


class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        String vowels = "AEIOUaeiou";

        while (l < r) {
            while (l < r && vowels.indexOf(arr[l]) == -1) l++;
            while (l < r && vowels.indexOf(arr[r]) == -1) r--;

            // swap vowels
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }

        return new String(arr);
    }
}

