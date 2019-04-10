/*
19.4 Write a program that takes as input a directed graph and checks
if the graph contains a cycle
*/
public boolean canFinish(int numCourses, int[][] prerequisites) {
    
    //Set up graph
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] course : prerequisites) {
        int crs = course[0];
        int pre = course[1];
        
        if (!map.containsKey(pre)) {
            map.put(pre, new HashSet<Integer>());
        }
        
        map.get(pre).add(crs);
    }
    
    Set<Integer> visited = new HashSet<>();
    Set<Integer> recurVisited = new HashSet<>();
    
    for (int crs : map.keySet()) {
        if (hasCycle(map, crs, visited, recurVisited))
            return false;
    }
    
    return true;
    
    
}

public boolean hasCycle(Map<Integer, Set<Integer>> map, int crs, Set<Integer> visited, Set<Integer> recurVisited) {
    visited.add(crs);
    recurVisited.add(crs);
    
    if (map.containsKey(crs)) {
        for (int next : map.get(crs)) {
            if (recurVisited.contains(next)) {
                return true;
            } else if (!visited.contains(next) && hasCycle(map, next, visited, recurVisited)) {
                return true;
            }
        }
    }
    
    recurVisited.remove(crs);
    
    return false;
}