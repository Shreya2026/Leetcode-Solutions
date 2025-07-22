//brute force
/*class Solution {
    public double myPow(double x, int n) {
        double ans=1.0;
        long nn=n;
        if(n<-1) n=n*(-1);
        for(int i=1;i<=n;i++){
            ans*=x;
        }
        if(nn < -1) ans=1/ans;
        return ans;
    }
}*/


/*class Solution {
    public double myPow(double x, int n) {
        double ans=1.0;
        long nn=n;
        if(nn<1) nn=-1*nn;
        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn=nn-1;
            }else{
                x=x*x;
                nn=nn/2;
            }
        }
        if(n<0) ans=(double)1.0/(double)ans;
        return ans;
    }
}*/

class Solution {
    public double myPow(double x, int n) {
        long nn=n;
        if(nn<0){
            nn=-nn;
            x=1/x;
        }
        return power(x,nn);
    }
    private double power(double x,long n){
        if(n==0) return 1.0;

        if(n%2==1){
            return x*power(x,n-1);
        }
        else{
            return power(x*x,n/2);
        }
    }
}
