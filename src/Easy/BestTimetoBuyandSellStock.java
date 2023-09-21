package Easy;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        System.out.println("hr");
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxDiff = 0;

        int size = prices.length;
        for (int i = 0; i < size; i++){
            min = Math.min(prices[i], min);
            maxDiff = Math.max(prices[i] - min, maxDiff);
        }
        return maxDiff;
    }
}
