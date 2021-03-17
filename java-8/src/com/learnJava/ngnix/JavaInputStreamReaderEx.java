package com.learnJava.ngnix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaInputStreamReaderEx {

    public int[] findOrder(int numCourses, List<List<Integer>> prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new LinkedList<>());
        }

        for (int i = 0; i < prerequisites.size(); i++) {
            adj.get(prerequisites.get(i).get(0)).add(prerequisites.get(i).get(1));
        }
        boolean visited[] = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(visited, recStack, queue, adj, i))
                return new int[0];
        }
        int size = queue.size();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = queue.poll();
        return arr;
    }

    boolean isCyclic(boolean visited[], boolean[] recStack, Queue<Integer> queue, List<List<Integer>> adj, int i) {
        if (recStack[i])
            return true;
        if (visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children) {
            if (isCyclic(visited, recStack, queue, adj, c))
                return true;
        }
        queue.add(i);
        recStack[i] = false;
        return false;
    }

    public static void main(String[] args) throws IOException {


        InputStreamReader isr = new InputStreamReader(System.in,
                StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        String line;
        Integer n = null;
        List<List<Integer>> conditionsList = new ArrayList<>();


        while ((line = br.readLine()) != null && !line.equals("")) {
            if (null == n) {
                n = Integer.parseInt(line);
                System.out.println(n);
            } else {
                conditionsList.add(Stream.of(line.split(" ")).map(data -> Integer.parseInt(data)).collect(Collectors.toList()));
            }
        }
//        System.out.println(conditionsList);

        Integer[] what = Arrays.stream(new JavaInputStreamReaderEx().findOrder(n, conditionsList)).boxed().toArray(Integer[]::new);

        System.out.println(Arrays.toString(what).replaceAll("\\[|\\]|,|\\s", " ").strip());






    }


}
