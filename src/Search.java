import java.util.*;

public class Search<Vertex> {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public List<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex x = v; !x.equals(source); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }
}
