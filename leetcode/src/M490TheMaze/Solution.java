package M490TheMaze;

public class Solution {
    /**
     * DFS
     * Time Complexity O(mn) 2ms 88.12%
     * Space Complexity O(mn) 43.7MB 19.61%
     */
    int[][] maze;
    int[] destination;
    int[][] visited;
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.destination = destination;
        // left up right down
        this.visited = new int[maze.length][maze[0].length];
        m = maze.length;
        n = maze[0].length;
        return find(start[0], start[1]);
    }

    private boolean find(int i, int j) {
        if (visited[i][j] == 1) {
            return false;
        }
        if (destination[0] == i && destination[1] == j) {
            return true;
        }
        int r = j + 1;
        int l = j - 1;
        int u = i - 1;
        int d = i + 1;
        boolean flag = false;
        visited[i][j] = 1;
        while (r < n && maze[i][r] == 0) {
            r++;
        }
        flag |= find(i, r - 1);
        while (l >= 0 && maze[i][l] == 0) {
            l--;
        }
        flag |= find(i, l + 1);
        while (u >= 0 && maze[u][j] == 0) {
            u--;
        }
        flag |= find(u + 1, j);
        while (d < m && maze[d][j] == 0) {
            d++;
        }
        flag |= find(d - 1, j);
        return flag;
    }
}
