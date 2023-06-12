package Easy;

public class Sqrt {
    public static void main(String[] args) {
        int no = 8;
        System.out.println(mySqrt(no));
    }

    static int mySqrt(int x) {
        long r = x;
        while (r*r > x) r = (r + x/r) / 2;
        return (int) r;
    }
    public int mySqrt1(long x) {
        if(x==0) return 0;
        long low = 1,high = x,ans =0;
        while(low<=high){
            long mid =low + (high-low)/2;
            if(x/mid==mid)  return (int) mid;
            else if(x/mid<mid)   high=mid-1;
            else {low = mid+1; ans = mid;}
        }
        return (int) ans;
    }
}
