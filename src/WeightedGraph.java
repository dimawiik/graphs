import java.util.*;
public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        if (!map.containsKey(v)) {
            map.put(v, new LinkedList<>());
        }
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!map.containsKey(source)) addVertex(source);
        if (!map.containsKey(dest)) addVertex(dest);

        map.get(source).add(new Edge<>(source, dest, weight));
        if (undirected) {
            map.get(dest).add(new Edge<>(dest, source, weight));
        }
    }

    public List<Vertex> adjacencyList(Vertex v) {
        List<Vertex> neighbors = new LinkedList<>();
        for (Edge<Vertex> edge : map.get(v)) {
            neighbors.add(edge.getDest());
        }
        return neighbors;
    }

    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        return map.get(v);
    }
}
