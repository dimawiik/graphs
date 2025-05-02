
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 1);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");

        for (String v : graph.adjacencyList("A")) {
            System.out.println("Distance from A to " + v + ": " + dijkstra.getShortestDistance(v));
            System.out.println("Path: " + dijkstra.pathTo(v));
        }
    }
}
