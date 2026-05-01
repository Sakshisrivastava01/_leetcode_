class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        int ans = 0;
        boolean containOdd = false;

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch,0)+1);
        }

        for(int freq :  map.values()){
            if(freq%2 == 0){
                ans +=  freq;
            }
            else{
                ans += freq-1;
                containOdd = true;
            }
        }

        if(containOdd) return ans+1;
        else return ans;
    }
}