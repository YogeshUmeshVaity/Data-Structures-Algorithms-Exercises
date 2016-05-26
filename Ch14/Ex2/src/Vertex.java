import java.util.ArrayList;

/** Represents a vertex in a graph. */
public class Vertex {
    private char label;
    private ArrayList<Edge> edges;

    public Vertex(char label) {
        this.label = label;
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }


    public char getLabel() {
        return label;
    }

    @Override
    public String toString() {
        String string = Character.toString(label) + "   ";
        for (Edge edge : edges) {
            string += edge + " ";
        }
        return string;
    }
}
