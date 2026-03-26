class Solution {
public:
    int maximalSquare(vector<vector<char>>& mat) {
        int ans=0 , m=mat.size() , n=mat[0].size();
        vector<vector<long long>> arr(m,vector<long long> (n,0));
        for (int i=0 ; i<m; i++) {
            long long x=0;
            for (int j=0 ; j<n ; j++){
                x+=mat[i][j]-'0';
               arr[i][j]=x;
            }
        }

        int max=min(m,n);
        int z=1;
        while (z<=max){
            bool ok=0;
            int tar=z*z;
            for (int j=z-1 ; j<n && !ok; j++){ // col
                long long sum=0 , cnt=0;;
                for (int i=0 ; i<m ; i++){ //row
                    sum+=arr[i][j];
                    if (j-z>=0){
                        sum-=arr[i][j-z];
                    }
                    cnt++;
                    if (cnt==z){
                        if (sum==tar){
                            ans=z;
                            ok=1;
                            break;
                        }
                        else {
                            cnt--;
                            if (j-z>=0){
                                sum-=(arr[i-cnt][j]-arr[i-cnt][j-z]);
                            }
                            else {
                                sum-=arr[i-cnt][j];
                            }
                        }
                    }
                }
            }

            if (!ok){
                return ans*ans;
            }

            z++;
        }

        return ans*ans;
    }
};