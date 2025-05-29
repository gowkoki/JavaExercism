import java.util.*;

public class Graph {
    private final Map<String, Node> nodes = new HashMap<>();
    private final List<Edge> edges = new ArrayList<>();
    private final Map<String, String> attributes;
     
    public Graph() {
        this.attributes = new HashMap<>(); 
    }

    public Graph(Map<String, String> attributes) {
        this.attributes = new HashMap<>(attributes); 
    }

    public Collection<Node> getNodes() {
        return nodes.values();
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    public Graph node(String name) {
        nodes.putIfAbsent(name, new Node(name));
        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {
        nodes.putIfAbsent(name, new Node(name,attributes));
        return this;
    }

    public Graph edge(String start, String end) {
        return edge(start, end, Collections.emptyMap());
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        edges.add(new Edge(start, end, attributes));
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
