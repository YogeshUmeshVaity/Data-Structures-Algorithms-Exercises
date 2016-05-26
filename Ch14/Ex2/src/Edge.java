
/** Represents an edge between to vertices in a graph */
public class Edge {
    private static final int INFINITY = 1000000;
    private int weight;
    private Vertex endingVertex;

    public Edge(int weight, Vertex endingVertex) {
        this.weight = weight;
        this.endingVertex = endingVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getEndingVertex() {
        return endingVertex;
    }

    public void setEndingVertex(Vertex endingVertex) {
        this.endingVertex = endingVertex;
    }

    @Override
    public String toString() {
        return Integer.toString(weight) +  " -> " + endingVertex.getLabel();
    }
}
