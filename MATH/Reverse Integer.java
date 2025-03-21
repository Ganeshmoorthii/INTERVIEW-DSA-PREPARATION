/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Constraints:

-231 <= x <= 231 - 1*/

class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x!=0){
            int rem = x % 10;
            int new_res = 10 * res + rem;
            if((new_res-rem)/10 != res){
                return 0;
            }
            res = new_res;
            x = x /10;
            
        }
        return res;
        
    }
}
