class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int r=0;
        int ans=0;
        for(int l=0;l<s.length && r<g.length;l++){
            if(s[l]>=g[r]) {
                r++;
            }
        }
        return r;
    }
}