import java.util.*;

class Solution {
    public String getHappyString(int n, int k) {

        Queue<String> q = new LinkedList<>();
        q.add("a");
        q.add("b");
        q.add("c");

        List<String> happyStrings = new ArrayList<>();

        while (!q.isEmpty()) {

            String s = q.poll();

            if (s.length() == n) {
                happyStrings.add(s);
                continue;
            }

            char[] letters = {'a','b','c'};

            for (char ch : letters) {
                if (s.charAt(s.length() - 1) != ch) {
                    q.add(s + ch);
                }
            }
        }

        if (k > happyStrings.size()) {
            return "";
        }

        return happyStrings.get(k - 1);
    }
}