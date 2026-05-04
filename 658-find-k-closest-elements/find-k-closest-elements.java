class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        int l = 0 ,h = n - k;

        while(l < h){
            int m = l + (h - l)/2;

            int d1 = x - arr[m];
            int d2 = arr[m+k] - x;
            if(d1 > d2){
                // in range starting at st = m ,end = m+k
                // as it is a incresing array the resultant dis must be and[0] <= ans[k]

                // its a invalid region from l .. m
                // we search for better region from the right

                l = m+1;
            }
            else{
                // its a one of the valid region
                h = m;
            }
        }
        

        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        for(int i = l;i < l+k;i++){
            ans.add(arr[i]);
        }

        return ans;
    }
}