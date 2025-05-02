import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 2);
        graph.addEdge(c, d, 1);

        System.out.println("BFS:");
        new BreadthFirstSearch<String>().bfs(a);
        System.out.println("\nDijkstra:");
        Map<Vertex<String>, Double> distances = new DijkstraSearch<String>().dijkstra(a);
        distances.forEach((v, dist) -> System.out.println(v + ": " + dist));
    }
}
