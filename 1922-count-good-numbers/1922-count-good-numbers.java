class Solution {
    private static final long MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        long oddCount = n / 2;
        long evenCount = n - oddCount;
        long evenPart=modPow(5,evenCount,MOD);
        long oddPart=modPow(4,oddCount,MOD);
        return (int)((evenPart*oddPart)%MOD);
    }

    private long modPow(long base,long exp,long mod){
        long result=1;
        base%=mod;
        while(exp>0){
            if((exp&1)==1) result=(result*base)%mod;
            base=(base*base)%mod;
            exp>>=1;
        }
        return result;
    }
}