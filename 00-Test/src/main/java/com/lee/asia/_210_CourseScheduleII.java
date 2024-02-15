package com.lee.asia;

import com.sun.corba.se.spi.ior.iiop.IIOPFactories;
import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.util.*;

/**
 * @author: xiong.qiang
 * @date: 2023/6/16 14:20
 */
public class _210_CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> results = new ArrayList<>();
        int[] degree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList(numCourses);

        // 初始化
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        // 把入度为0的点放入队列中
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            results.add(course);
            count++;


            for (Integer c : edges.get(course)) {
                degree[c]--;
                if (degree[c] == 0) {
                    queue.add(c);
                }
            }
        }

        // 判断是否有拓扑排序
        if (count != numCourses) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = results.get(i);
        }
        return res;
    }
    //初始化一个int[] inDegree保存每一个结点的入度。
    //对于图中的每一个结点的子结点，将其子结点的入度加1。
    //选取入度为0的结点开始遍历，并将该节点加入输出。
    //对于遍历过的每个结点，更新其子结点的入度：将子结点的入度减1。
    //重复步骤3，直到遍历完所有的结点。
    //如果无法遍历完所有的结点，则意味着当前的图不是有向无环图。不存在拓扑排序。

    //Input: numCourses = 2, prerequisites = [[1,0]]
    //Output: [0,1]
    //Explanation: There are a total of 2 courses to take.
    // To take course 1 you should have finished course 0. So the correct course order is [0,1].
    //
    public static void main(String[] args) {
        int[] order = findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        System.out.println(Arrays.toString(order));
        System.out.println(1<<3);
    }
}
