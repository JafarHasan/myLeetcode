class Solution {
    // TC:o(n) SC;o(1) n=noOfBottles
    public int numWaterBottles1(int bottles, int exchange) {
        int cnt = 0;
        int consume = 0;
        int remain = 0;
        while (bottles >= exchange) {
            consume += exchange;
            bottles -= exchange;
            bottles += 1;
        }
        return consume + bottles;
    }

    // 2nd Approach
    // TC:O(logN) SC:O(1)
    public int numWaterBottles2(int bottles, int exchange) {
        int consume = bottles;// drink all bottles
        int remain = 0;
        int empty = bottles;// all bottles are empty after consumed
        while (empty >= exchange) {
            int extraFullBottles = empty / exchange;
            remain = empty % exchange;

            consume += extraFullBottles;// consumed all full bottles
            empty = remain + extraFullBottles;
        }

        return consume;
    }

    // 3RD
    // TC:O(1) SC:O(1)
    public int numWaterBottles(int bottles, int exchange) {
        return bottles + (bottles - 1) / (exchange - 1);
    }

}
