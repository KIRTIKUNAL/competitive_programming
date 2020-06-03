//Two city scheduling
/*
 *There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 *Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
*/


/*
 * In this problem we are using the greedy approach to select the city. For every person there is choice to send 
 * him either to city A( COST = costs[i][0]) or city B (COST = costs[i][1]). So for each person we will select  
 * the minimum of two costs.
 * Remember : We have to sort the given array on the basis of diff of cosA and Cost B. so that max differnce will 
 *            could be handled first.
 */

class Solution {
    public int twoCitySchedCost(int[][] costs) {

        //sort the costs based on the absolute differences
        Arrays.sort(costs, (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));

        int noOfPeopleSentToA = 0, noOfPeopleSentToB = 0;
        int totalPeople = costs.length;
        int totalCostIncurred = 0;
        int capacityOfCityA = totalPeople / 2;
        int capacityOfCityB = totalPeople / 2;

        for (int i = 0; i < totalPeople; i++) {
            if (costs[i][0] < costs[i][1]) //if cost to cityA is less than B 
            {
                if (noOfPeopleSentToA != capacityOfCityA) // if city A still has capacity
                {
                    totalCostIncurred += costs[i][0];
                    noOfPeopleSentToA++;

                } else // send people to city B
                {
                    totalCostIncurred += costs[i][1];
                    noOfPeopleSentToB++;
                }

            } else // if cost to sending B is less than A
            {

                if (noOfPeopleSentToB != capacityOfCityB) // If city B still has capacity
                {
                    noOfPeopleSentToB++;
                    totalCostIncurred += costs[i][1];

                } else // send people to city A
                {
                    noOfPeopleSentToA++;
                    totalCostIncurred += costs[i][0];

                }

            }

        }

        return totalCostIncurred;

    }
}
