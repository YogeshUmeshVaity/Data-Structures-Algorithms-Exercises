class Edge {
    public int sourceVertex;
    public int destinationVertex;
    public int distance;

    public Edge(int sourceVertex, int destinationVertex, int distance) {
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
        this.distance = distance;
    }
}

class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab) {
        label = lab;
        isInTree = false;
    }

}

class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int numVertices;
    private int currentVert;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        numVertices = 0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjacencyMatrix[j][k] = INFINITY;
    }

    public void addVertex(char lab) {
        vertexList[numVertices++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
        adjacencyMatrix[end][start] = weight;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void showMatrix() {
        System.out.println();
        System.out.print("  ");
        for(int column = 0; column < numVertices; column++) {
            System.out.print(vertexList[column].label + "  ");
        }
        System.out.println();
        for(int i = 0; i < numVertices; i++) {
            System.out.print(vertexList[i].label + " ");
            for(int j = 0; j < numVertices; j++) {
                String currentElement = Integer.toString(adjacencyMatrix[i][j]);
                if(adjacencyMatrix[i][j] == INFINITY) {
                    currentElement = "--";
                }
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
    }

}

class TravelingSalesman {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');    // 0
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('C');    // 2
        theGraph.addVertex('D');    // 3
        theGraph.addVertex('E');    // 4

        theGraph.addEdge(0, 1, 91);  // AB  6
        theGraph.addEdge(1, 4, 31);  // AD  4
        theGraph.addEdge(4, 3, 83); // BC 10
        theGraph.addEdge(3, 0, 55);  // BD  7
        theGraph.addEdge(0, 2, 62);  // BE  7
        theGraph.addEdge(2, 4, 45);  // CD  8
        theGraph.addEdge(3, 2, 52);  // CE  5
        theGraph.addEdge(2, 1, 44);  // CF  6

        theGraph.showMatrix();
    }
}

