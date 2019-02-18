///////////////////////////////////////////////////////////////////////
/*
19.1 Search a maze
Given a 2D array of black and white entries representing a maze
with designated entrance and exit points, find a path from the entrance to exit, 
if one exists
*/
public List<Coordinate> searchMaze(int[][] maze, Coordinate s, Coordinate e) {
    List<Coordinate> path = new ArrayList<>();
    maze[s.x][s.y] = 1;
    path.add(s);
    if (!searchMazeHelper(maze, s, e, path))
        path.remove(path.size() - 1);
    
    return path; //Empty path means no path between s and e
}
//DFS Maze Helper
public boolean searchMazeHelper(int[][] maze, Coordinate curr, Coordinate e, List<Coordinate> path) {
    if (curr.equals(e))
        return true;
    int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {0, -1}};
    for (int[] shift : SHIFT) {
        Coordinate next = new Coordinate(curr.x + shift[0], curr.y + shift[1]);
        if (isValid(next, maze)) {
            maze[next.x][next.y] = 1;
            path.add(next);
            if (searchMazeHelper(maze, next, e, path))
                return true;
            path.remove(path.size() - 1);
        }
    }

    return false;   
}
//Checks if the point is an open space
public boolean isValid(Coordinate cur, int[][] maze) {
    return (curr.x >= 0 && curr.x < maze.length 
        && curr.y >= 0 && curr.y < maze[0].length
        && maze[curr.x][curr.y] == 0);
}
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
/*
19.2 Paint a Boolean Matrix
Implement a routine that takes an n x m array and flips the color of the region associated with
the starting point
*/
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] == newColor)
        return image;
    DFSHelper(image, sr, sc, image[sr][sc], newColor);
    return image;
}

public void DFSHelper(int[][] image, int sr, int sc, int color, int newColor) {
    if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && (image[sr][sc] == color)) {
        image[sr][sc] = newColor;
        DFSHelper(image, sr + 1, sc, color, newColor);
        DFSHelper(image, sr - 1, sc, color, newColor);
        DFSHelper(image, sr, sc + 1, color, newColor);
        DFSHelper(image, sr, sc - 1, color, newColor);
    }
}
///////////////////////////////////////////////////////////////////////

/*
19.4 Deadlock Detection
Write a program that takes as input a directed graph and checks if 
the graph contains a cycle
*/
public boolean hasCycle(Vertex v, Set<Vertex> marked, Set<Vertex> currStack) {
    marked.add(v);
    currStack.add(v);

    for(Vertex u : v.edges) {
        if (!marked.contains(u)) {
            return hasCycle(u, marked, currStack);
        } else if (currStack.contains(u)) {
            return true;
        }
    }

    currStack.remove(v);
    return false;
}

/*
19.5 Clone Graph
Design an algorithm that takes a reference to a vertex u, and creates a 
copy of the graph on the vertices reachable from u
Return the copy of u
*/
//BFS
public Node cloneGraph(Node node) {
    Map<Node, Node> map = new HashMap<>();
    Queue<Node> q = new LinkedList<>();
    q.offer(node);
    map.put(node, new Node(node.label));

    while (!q.isEmpty()) {
        Node curr = q.poll();

        for (Node nei : curr.neighbors) {
            if (!map.containsKey(nei)) {
                q.add(nei);
                map.put(nei, new Node(nei.label));
            }
            //Add its neighbors
            map.get(curr).neighbors.add(map.get(nei));
        }
    }

    return map.get(node);
}

//DFS
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    return cloneGraphUtil(node, map);
}

public UndirectedGraphNode cloneGraphUtil(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
    if (node == null)
        return null;
    
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(node, copy);
    for (UndirectedGraphNode curr : node.neighbors) {
        if (!map.containsKey(curr)) {
            cloneGraphUtil(curr, map);
        }
        copy.neighbors.add(map.get(curr));
    }
    
    return copy;
}

/*
19.7 Transform One String to another
Given a dictionary D and two strings s and t, write a program to determine
if s produces t, output the length of the shortest production sequence
*/
class WordNode{
    String word;
    int numSteps;
 
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}

public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
    Queue<WordNode> queue = new LinkedList<WordNode>();
    queue.add(new WordNode(beginWord, 1));

    wordDict.add(endWord);

    while(!queue.isEmpty()){
        WordNode top = queue.poll();
        String word = top.word;

        if(word.equals(endWord)){
            return top.numSteps;
        }

        char[] arr = word.toCharArray();
        for(int i=0; i<arr.length; i++){
            for(char c='a'; c<='z'; c++){
                char temp = arr[i];
                if(arr[i]!=c){
                    arr[i]=c;
                }

                String newWord = new String(arr);
                if(wordDict.contains(newWord)){
                    queue.offer(new WordNode(newWord, top.numSteps+1));
                    wordDict.remove(newWord);
                }

                arr[i]=temp;
            }
        }
    }

    return 0;
}
//Topological Sort
public Stack<Node> topSortUtil(Node node, Set<Node> set, Stack<Node> stack) {
    set.add(node);
    for (Node n : node.neighbors) {
        if (!set.contains(n)) {
            topSortUtil(n, set, stack);
        }
    }
    stack.push(node);
    return stack;
}

public List<Integer> topSort(Node node) {
    Set<Node> set = new HashSet<>();
    Stack<Node> stack = new Stack<>();
    List<Integer> ls = new ArrayList<>();

    stack = topSortUtil(node, set, stack);
    while (!stack.isEmpty()) {
        ls.add(stack.pop().val);
    }

    return ls;
}

/*
Course Schedule (Topological Sort)
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/
public boolean canFinish(int numCourses, int[][] prereqruisites) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int[] indegree = new int[numCourses];
    for (int[] edge : prereqruisites) {
        int src = edge[1];
        int sink = edge[0];
        if (!adj.containsKey(src)) {
            adj.put(src, new ArrayList<>());
        }
        adj.get(src).add(sink);
        indegree[sink]++;
    }
    
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0)
            q.offer(i);
    }
    int count = 0;
    while (!q.isEmpty()) {
        int pre = q.poll();
        count++;
        if (adj.containsKey(pre)) {
            for (int next : adj.get(pre)) {
                if (--indegree[next] == 0)
                    q.offer(next);
            }
        }
    }
    
    return count == numCourses;
    
    
}
