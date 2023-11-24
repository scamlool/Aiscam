import java.util.*;

class Node implements Comparable<Node> {
    int value;
    int heuristic;

    public Node(int value, int heuristic) {
        this.value = value;
        this.heuristic = heuristic;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.heuristic, other.heuristic);
    }
}

public class BestFirstSearch {
    public static void main(String[] args) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2, 3));
        graph.put(1, Arrays.asList(4,7,9));
        graph.put(2, Arrays.asList(4,6));
        graph.put(3, Arrays.asList(7,8));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(9));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList());
        graph.put(8, Arrays.asList(9));
        graph.put(9, Arrays.asList());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start state: ");
        int startState = scanner.nextInt();

        System.out.print("Enter the goal state: ");
        int goalState = scanner.nextInt();

        scanner.close();

        Map<Integer, Integer> heuristicValues = calculateManhattanHeuristics(graph, goalState);

        // printing heuristic Vaules 
        for (Map.Entry<Integer, Integer> entry : heuristicValues.entrySet()) {
            System.out.println("Heuristic for Node " + entry.getKey() + ": " + entry.getValue());
        }

        List<Integer> path = bestFirstSearch(graph, heuristicValues, startState, goalState);
        System.out.println("Path: " + path);
    }

    public static Map<Integer, Integer> calculateManhattanHeuristics(Map<Integer, List<Integer>> graph, int goal) {

        Map<Integer, Integer> heuristicValues = new HashMap<>();

        Map<Integer, int[]> nodeCoordinates = new HashMap<>();
        nodeCoordinates.put(0, new int[] { 0, 0 });
        nodeCoordinates.put(1, new int[] { 1,2 });
        nodeCoordinates.put(2, new int[] { 2,4 });
        nodeCoordinates.put(3, new int[] { 3,7 });
        nodeCoordinates.put(4, new int[] { 6,5 });
        nodeCoordinates.put(5, new int[] { 7,8 });
        nodeCoordinates.put(6, new int[] { 8,4 });
        nodeCoordinates.put(7, new int[] { 9,2 });
        nodeCoordinates.put(8, new int[] { 8,7 });
        nodeCoordinates.put(9, new int[] { 10,6 });

        int[] goalCoordinates = nodeCoordinates.get(goal);

        for (int node : graph.keySet()) {
            int[] coordinates = nodeCoordinates.get(node);
            int distance = calculateManhattanDistance(coordinates, goalCoordinates);
            heuristicValues.put(node, distance);
        }

        return heuristicValues;
    }

    private static int calculateManhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public static List<Integer> bestFirstSearch(Map<Integer, List<Integer>> graph,
        Map<Integer, Integer> heuristicValues, int start, int goal) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Map<Integer, Integer> parent  = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(new Node(start, heuristicValues.get(start)));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int current = currentNode.value;

            // check if we reached to goal state or not 
            if (current == goal) {
                return reconstructPath(parent, current);
            }

            visited.add(current);

            // traverse all neighbors of the current state 
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    parent.put(neighbor, current);
                    queue.offer(new Node(neighbor, heuristicValues.get(neighbor)));
                }
            }
        }

        return Collections.emptyList();
    }

    public static List<Integer> reconstructPath(Map<Integer, Integer> parent, int goal) {

        List<Integer> path = new ArrayList<>();
        while (parent.containsKey(goal)) {
            path.add(goal);
            goal = parent.get(goal);
        }
        path.add(goal);
        Collections.reverse(path);
        return path;
    }
}