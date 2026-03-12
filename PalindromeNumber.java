class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int n = x;
       if(x<0){
        return false;
       } else{
        while(n!=0){
            rev = rev*10 + n%10;
            n = n/10;
        }
        
       }
       return (rev == x);
    }
}