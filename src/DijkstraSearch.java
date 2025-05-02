import java.util.*;

public class DijkstraSearch<V> {
    public Map<Vertex<V>, Double> dijkstra(Vertex<V> start) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Map.Entry<Vertex<V>, Double>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Set<Vertex<V>> visited = new HashSet<>();

        distances.put(start, 0.0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0.0));

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll().getKey();

            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double edgeWeight = neighborEntry.getValue();
                double newDist = distances.get(current) + edgeWeight;

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    pq.add(new AbstractMap.SimpleEntry<>(neighbor, newDist));
                }
            }
        }

        return distances;
    }
}

