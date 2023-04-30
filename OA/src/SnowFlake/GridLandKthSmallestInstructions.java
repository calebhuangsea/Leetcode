package SnowFlake;

/**
 * https://www.1point3acres.com/bbs/thread-971155-1-1.html
 */
public class GridLandKthSmallestInstructions {
    public static void main(String[] args) {

    }
//    class Solution:
//    def getSafePaths(self, journeys):
//            # create dp array
//    # using dynammic programming, due to the limitation of x and y is 10, I gave the range from 0~11
//
//    dp = [[1 for i in range(11)] for j in range(11)]
//
//            # the number of ways on the dp[i][j] position is equal dp[i-1][j] + dp[i][j-1]
//            for i in range(1, 11):
//            for j in range(1,11):
//    dp[i][j] = dp[i-1][j] + dp[i][j-1]
//    res = []
//            # use for loop to take a look each paramater and split it by space
//        for journey in journeys:
//    paramater = journey.split()
//    x = int(paramater[0])
//    y = int(paramater[1])
//    k = int(paramater[2])+1
//    result = ""
//
//            # from the dp[x][y] backtracking the path we want.
//        # if dp[x-1][y] >= k, it means the path is start from H, otherwise, from V.
//        # we need to reduce the number of combination which starts from H.
//            while( x > 0 and y > 0):
//            if dp[x-1][y] >= k:
//    result += "H"
//    x-=1
//            else:
//    result += "V"
//    k-=dp[x-1][y]
//    y-=1
//            while y > 0:
//    result += "V"
//    y-=1
//            while x > 0:
//    result += "H"
//    x-=1
//
//            res.append(result)
//
//            return res
//
}
