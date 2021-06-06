0-1 knapsack problem: 
 loop order: always item first, then inner loop for volume

DB and recursive/backtracking+memory
All questions can be solved by reducing into  smaller problems;
two strategies:
1) decrease by one: dp[i] = dp[i-1] or Min/Max dp[j:i];
2) divide into two parts:
    dp[i][j] = (Min/Max) dp[i][k-1] + dp[K+1][j]
   
example: 


            



