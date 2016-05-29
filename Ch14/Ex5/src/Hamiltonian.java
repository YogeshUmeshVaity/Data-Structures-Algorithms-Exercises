class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab) {
        label = lab;
        isInTree = false;
    }
}

class Graph {
    private static final int HOME_TOWN = 0;
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int numVertices;
    private int sequenceCount = 0;

    // Stores temporary vertex number that will be anagrammed.
    private int vertexNumbers[];

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

    public void startJourney() {
        decideTownsToAnagram();
        doAnagram(numVertices - 1);
        System.out.println("Sequences tested : " + sequenceCount);
    }

    private void doAnagram(int newSize) {
        int limit;
        if (newSize == 1)
            return;

        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                int totalDistance = calculateTotalDistance();
                sequenceCount++;
                if (totalDistance < INFINITY) {
                    printCurrentSequence(vertexNumbers);
                    System.out.print(" = " + totalDistance + "\n");
                }
            }
            rotateVertices(newSize);
        }
    }

    private void printCurrentSequence(int[] vertexSequence) {
        System.out.print(vertexList[HOME_TOWN].label);
        for (int vertexNumber : vertexSequence) {
            System.out.print(vertexList[vertexNumber].label);
        }
        System.out.print(vertexList[HOME_TOWN].label);
    }

    // Calculates the total distance between current series of towns.
    private int calculateTotalDistance() {
        int total = 0;

        // First add distances of the anagrammed vertices
        for (int i = 0; i < vertexNumbers.length - 1; i++) {
            total += adjacencyMatrix[vertexNumbers[i]][vertexNumbers[i + 1]];
        }

        // Add the distance from first vertex to anagrammed vertices total distance.
        total += adjacencyMatrix[HOME_TOWN][vertexNumbers[0]];

        // Add the distance from first vertex to last vertex
        total += adjacencyMatrix[vertexNumbers[vertexNumbers.length - 1]][HOME_TOWN];
        return total;
    }

    private void rotateVertices(int newSize) {
        int j;
        int position = vertexNumbers.length - newSize;
        int temp = vertexNumbers[position];                      // save first vertex
        for (j = position + 1; j < vertexNumbers.length; j++)       // shift others left
            vertexNumbers[j - 1] = vertexNumbers[j];
        vertexNumbers[j - 1] = temp;                                // put first on right
    }

    // Copies vertex numbers to int array, this array will be anagrammed.
    // Since we start from home town(A), we'll exclude the starting vertex(A).
    private void decideTownsToAnagram() {
        vertexNumbers = new int[numVertices - 1];
        for (int i = 1; i < numVertices; i++) {
            vertexNumbers[i - 1] = i;
        }
    }

    public void showMatrix() {
        System.out.println();
        System.out.print("  ");
        for (int column = 0; column < numVertices; column++) {
            System.out.print(vertexList[column].label + "  ");
        }
        System.out.println();
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j < numVertices; j++) {
                String currentElement = Integer.toString(adjacencyMatrix[i][j]);
                if (adjacencyMatrix[i][j] == INFINITY) {
                    currentElement = "--";
                }
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
    }
}

class Hamiltonian {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');    // 0
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('C');    // 2
        theGraph.addVertex('D');    // 3
        theGraph.addVertex('E');    // 4

        theGraph.addEdge(0, 1, 91);  // AB  6
        theGraph.addEdge(1, 4, 31);  // AD  4
        theGraph.addEdge(4, 3, 83);  // BC 10
        theGraph.addEdge(3, 0, 55);  // BD  7
        theGraph.addEdge(0, 2, 62);  // BE  7
        theGraph.addEdge(2, 4, 45);  // CD  8
        theGraph.addEdge(3, 2, 52);  // CE  5
        theGraph.addEdge(2, 1, 44);  // CF  6

        //theGraph.showMatrix();
        theGraph.startJourney();
    }
}
