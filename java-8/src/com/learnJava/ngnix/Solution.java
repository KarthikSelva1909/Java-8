package com.learnJava.ngnix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int[] findOrder(int numCourses, List<List<Integer>> prerequisites) {
        List<List<Integer>> adj =  new ArrayList<>(numCourses);

        for(int i=0;i<numCourses;i++){
            adj.add(new LinkedList<>());
        }

        for(int i=0;i<prerequisites.size();i++){
            adj.get(prerequisites.get(i).get(0)).add(prerequisites.get(i).get(1));
        }
        boolean visited[]= new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(isCyclic(visited,recStack,queue,adj,i))
                return new int[0];
        }
        int size = queue.size();
        int arr[] = new int[size];
        for(int i=0;i<size;i++)
            arr[i] = queue.poll();
        return arr;
    }
    boolean isCyclic(boolean visited[], boolean[] recStack, Queue<Integer> queue, List<List<Integer>> adj, int i){
        if (recStack[i])
            return true;
        if (visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children) {
            if (isCyclic(visited, recStack,queue,adj,c))
                return true;
        }
        queue.add(i);
        recStack[i] = false;
        return false;
    }

}
