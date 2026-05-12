import java.util.*;

class Solution {

    public boolean canFinish(int[][] tasks, int energy) {

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            if (energy < minimum) {
                return false;
            }

            energy -= actual;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) ->
                (b[1] - b[0]) - (a[1] - a[0]));

        int low = 1;
        int high = 1000000000;

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(tasks, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}