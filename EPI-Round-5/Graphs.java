import javax.management.Query;

/**
 * Search a maze
 */
private class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public boolean searchMazeBFS(int[][] maze, int startX, int startY, int endX, int endY) {
    
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    Queue<Coordinate> queue = new LinkedList<>();
    queue.offer(new Coordinate(startX, startY));
    
    while (!queue.isEmpty()) {
        Coordinate curr = q.poll();

        if (curr.x == endX && curr.y == endY) {
            return true;
        }

        int[][] neighbors = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] neighbor : neighbors) {
            int neiX = neighbor[0];
            int neiY = neighbor[1];

            if (neiX >= 0 && neiX < maze.length && neiY >= 0 && neiY < maze[0].length) {
                if (!visited[neiX][neiY] && maze[neiX][neiY] == 0) {
                    visited[neiX][neiY] = true;
                    queue.offer(new Coordinate(neiX, neiY));
                }
            }
        }

    }

    return false;
}

public boolean searchMazeDFS(int[][] maze, int startX, int startY, int endX, int endY) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    return searchMaze(maze, visited, startX, startY, endX, endY);
}

public boolean searchMaze(int[][] maze, boolean[][] visited, int currX, int currY, int endX, int endY) {
    if (currX == endX && currY == endY) {
        return true;
    }

    visited[currX][currY] = true;
    int[][] neighbors = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    for (int[] neighbor : neighbors) {
        int neiX = neighbor[0];
        int neiY = neighbor[1];

        if (neiX >= 0 && neiX < maze.length && neiY >= 0 && neiY < maze[0].length) {
            if (!visited[neiX][neiY] && maze[neiX][neiY] == 0) {
                return searchMaze(maze, visited, neiX, neiY, endX, endY);
            }
        }
    }

    return false;

}

/**
 * Cycle Detection
 */
public boolean canFinish(int numCourses, int[][] prerequisites) {
    int count = 0;
    int[] indegree = new int[numCourses];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    
    for (int [] pair: prerequisites) {
        int preReq = pair[1];
        int curr = pair[0];
        
        indegree[curr]++;
        if (!map.containsKey(preReq)) {
            map.put(preReq, new HashSet<Integer>());
        }
        
        map.get(preReq).add(curr);
    }
    
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < indegree.length; i++) {
        if (indegree[i] == 0) {
            q.offer(i);
        }
    }
    
    while(!q.isEmpty()) {
        int curr = q.poll();
        count++;
        
        if (map.containsKey(curr)) {
            for (int post : map.get(curr)) {
                if (--indegree[post] == 0) {
                    q.offer(post);
                }
            }  
        }
    }
    
    return count == numCourses;
}

public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    
    for (int [] pair: prerequisites) {
        int preReq = pair[1];
        int curr = pair[0];
        
        if (!map.containsKey(preReq)) {
            map.put(preReq, new HashSet<Integer>());
        }
        
        map.get(preReq).add(curr);
    }
    
    Set<Integer> visited = new HashSet<>();
    Set<Integer> recurVisited = new HashSet<>();
    
    for (int i = 0; i < numCourses; i++) {
        if (hasCycle(map, i, new HashSet<Integer>(), new HashSet<Integer>())) {
            return false;
        }
    }
    
    return true;
    
}

public boolean hasCycle(Map<Integer, Set<Integer>> map, int crs, Set<Integer> visited, Set<Integer> recurVisited) {
    visited.add(crs);
    recurVisited.add(crs);
    
    if (map.containsKey(crs)) {
        for (int post : map.get(crs)) {
            if (recurVisited.contains(post) || !visited.contains(post) && hasCycle(map, post, visited, recurVisited)) {
                return true;
            }
        }
    }
    
    recurVisited.remove(crs);
    return false;
}



/**
 * Graph is valid tree
 */

public boolean validTreeBFS(int n, int[][] edges) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
        int a = edge[0];
        int b = edge[1];
        
        if (!map.containsKey(a)) {
            map.put(a, new HashSet<Integer>());
        }
        
        if (!map.containsKey(b)) {
            map.put(b, new HashSet<Integer>());
        }
        
        map.get(a).add(b);
        map.get(b).add(a);
    }
    
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    
    while(!q.isEmpty()) {
        int curr = q.poll();
        if (visited.contains(curr)) {
            return false;
        }
        visited.add(curr);
        if (map.containsKey(curr)) {
            for (int nei : map.get(curr)) {
                if (!visited.contains(nei)) {
                    q.offer(nei);
                    map.get(nei).remove(curr);
                }
            }
        }
    }
    
    return visited.size() == n;
}

public boolean validTreeDFS(int n, int[][] edges) {
    if (edges.length != n - 1) return false;
    
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
        int a = edge[0];
        int b = edge[1];
        
        if (!map.containsKey(a)) {
            map.put(a, new HashSet<Integer>());
        }
        
        if (!map.containsKey(b)) {
            map.put(b, new HashSet<Integer>());
        }
        
        map.get(a).add(b);
        map.get(b).add(a);
    }
    Set<Integer> visited = new HashSet<>();
    DFS(map, visited, 0);
    
    
    return visited.size() == n;
}

public void DFS(Map<Integer, Set<Integer>> map, Set<Integer> visited, int node) {
    if (visited.contains(node)) {
        return;
    }
    visited.add(node);
    if (map.containsKey(node)) {
        for (int nei : map.get(node)) {
            if (!visited.contains(nei)) {
                map.get(nei).remove(node);
                DFS(map, visited, nei);
            }
        }
    }
}