import java.util.*;

public class P00133_Clone_Graph {
    public static void main(String[] args) {
        int[][] adjList = {{2,4},{1,3},{2,4},{1,3}};
        P00133_Clone_Graph solution = new P00133_Clone_Graph();
        Node graph = solution.buildGraph(adjList);
        solution.printGraphUsingBFS(graph);
        Node cloneGraph = solution.cloneGraph(graph);
        solution.printGraphUsingBFS(cloneGraph);
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
       Map<Node , Node> map = new HashMap<>();
       Deque<Node> queue = new ArrayDeque<>();
       queue.offer(node);
       map.put(node ,  new Node(node.val));
       while (!queue.isEmpty()){
           Node current = queue.poll();
           for(Node neighbour : current.neighbors){
               if(!map.containsKey(neighbour)){
                   map.put(neighbour , new Node(neighbour.val));
                   queue.offer(neighbour);
               }
               map.get(current).neighbors.add(map.get(neighbour));
           }
       }
       return map.get(node);
    }

    private void printGraphUsingBFS(Node node){
        if(node == null){
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node.val);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.val + "-> ");
            for( Node neighbour : current.neighbors){
                System.out.print(neighbour.val + " ");
               if(!visited.contains(neighbour.val)){
                   queue.offer(neighbour);
                   visited.add(neighbour.val);
               }
            }
            System.out.println();
        }
    }

    private Node buildGraph(int[][] edges) {
        Map<Integer , Node>  map =  new HashMap<>();
        for(int i = 1; i <= edges.length; i++){
           map.put(  i , new Node( i ) );
        }
        for (int i = 0; i < edges.length; i++){
            Node vertex = map.get(i+1);
            for(int j = 0 ; j <  edges[i].length; j++){
                int nodeVal = edges[i][j];
                vertex.neighbors.add(map.get(nodeVal));
            }
        }

        return map.get(1);
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
