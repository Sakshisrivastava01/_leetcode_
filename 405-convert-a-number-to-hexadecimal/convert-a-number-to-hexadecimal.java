class Solution {
    public String toHex(int num) {
        if (num == 0)
            return "0";

        long n = num & 0xffffffffL;
        String result = "";

        while (n > 0) {
            long rem = n & 15;
            if (rem < 10) {
                result = (char) ('0' + rem) + result;
            } else {
                result = (char) ('a' + (rem - 10)) + result;
            }
            n = n >> 4;
        }
        return result;
    }
}