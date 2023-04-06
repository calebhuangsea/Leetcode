package M207CourseSchedule;

import java.util.*;

public class Solution {
    /**
     * DFS track cycle
     * O(V + E) 6ms 49.87%
     * O(V + E) 42.8MB 70.48%
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // course -> list of next courses
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

        // build the graph first
        for (int[] relation : prerequisites) {
            // relation[0] depends on relation[1]
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }

        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if (this.isCyclic(currCourse, courseDict, checked, path))
                return false;
        }

        return true;
    }


    /*
     * postorder DFS check that no cycle would be formed starting from currCourse
     */
    protected boolean isCyclic(
            Integer currCourse, HashMap<Integer, List<Integer>> courseDict,
            boolean[] checked, boolean[] path) {

        // bottom cases
        if (checked[currCourse])
            // this node has been checked, no cycle would be formed with this node.
            return false;
        if (path[currCourse])
            // come across a previously visited node, i.e. detect the cycle
            return true;

        // no following courses, no loop.
        if (!courseDict.containsKey(currCourse))
            return false;

        // before backtracking, mark the node in the path
        path[currCourse] = true;

        boolean ret = false;
        // postorder DFS, to visit all its children first.
        for (Integer child : courseDict.get(currCourse)) {
            ret = this.isCyclic(child, courseDict, checked, path);
            if (ret)
                break;
        }

        // after the visits of children, we come back to process the node itself
        // remove the node from the path
        path[currCourse] = false;

        // Now that we've visited the nodes in the downstream,
        // we complete the check of this node.
        checked[currCourse] = true;
        return ret;
    }

    /**
     * Topological iteration and DFS approach
     * Time Complexity O(V + E) 25ms 8.35%
     * Space Complexity O(V + E) 61.7MB 5.7%
     */
//    public boolean canFinish(int n, int[][] prerequisites) {
//        // course[i]: number of prerequisite before this class
//        int[] courses = new int[n];
//        // path[i][j]: i is a prerequiste of j
//        int[][] path = new int[n][n];
//        for (int[] require : prerequisites) {
//            courses[require[1]]++;
//            path[require[0]][require[1]] = 1;
//        }
//        // start from course with no prerequisite
//        for (int i = 0; i < n; i++) {
//            if (courses[i] == 0) {
//                dfs(i, path, courses);
//            }
//        }
//        for (int i : courses) {
//            if (i > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void dfs(int i, int[][] path, int[] courses) {
//        for (int j = 0; j < path.length; j++) {
//            if (path[i][j] == 1) {
//                courses[j]--;
//                if (courses[j] == 0) {
//                    dfs(j, path, courses);
//                }
//            }
//        }
//    }
}
