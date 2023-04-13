package src.Easy;

import src.Util.DsaUtility;

public class ReveseBits {
    public static void main(String[] args) {
        System.out.println(DsaUtility.binaryToInt("00000010100101000001111010011100"));
        System.out.println(reverseBits(DsaUtility.binaryToInt("00000010100101000001111010011100")));
    }

    synchronized static int reverseBits(int n){
        int ans = 0;
        for (int i = 0; i < 32; i++)
            if ((n >> i & 1) == 1)
                ans |= 1 << 31 - i;
        return ans;
    }
}
