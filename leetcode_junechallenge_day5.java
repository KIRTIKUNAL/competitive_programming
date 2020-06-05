// Random pick with weight

/*
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

*/


class Solution {
    Random rand;
    int[] weight;
    int totalWeight;

    public Solution(int[] w) {
        rand = new Random();
        this.weight = w;
        totalWeight = weight[0];

        for (int i = 1; i < weight.length; i++) {
            totalWeight += weight[i];
            weight[i] += weight[i - 1];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(totalWeight) + 1;

        int left = 0, right = weight.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (weight[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return weight[left] >= target ? left : right;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
