
public class Solution {
    public int[] solution(int[] prices) {
        /**
         * 1, 2, 3, 2, 3
         * 4, 3, 1, 1, 0
         *
         * 1, 2, 5, 6, 2, 4, 1, 5
         * 7, 5, 2, 1, 2, 1, 1, 0
         *
         * 4, 5, 1
         * 2, 1, 0
         */

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; ++i) {
            for (int j = i; j < prices.length - 1; ++j) {
                if (prices[i] <= prices[j]) {
                    answer[i] += 1;
                } else {
                    break;
                }
            }
        }


        return answer;
    }
}
