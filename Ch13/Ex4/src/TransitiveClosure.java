// dfs.java
// demonstrates depth-first search
// to run this program: C>java DFSApp
////////////////////////////////////////////////////////////////
class StackX
{
    private final int SIZE = 20;
    private int[] st;
    private int top;
    // ------------------------------------------------------------
    public StackX()           // constructor
    {
        st = new int[SIZE];    // make array
        top = -1;
    }
    // ------------------------------------------------------------
    public void push(int j)   // put item on stack
    { st[++top] = j; }
    // ------------------------------------------------------------
    public int pop()          // take item off stack
    { return st[top--]; }
    // ------------------------------------------------------------
    public int peek()         // peek at top of stack
    { return st[top]; }
    // ------------------------------------------------------------
    public boolean isEmpty()  // true if nothing on stack
    { return (top == -1); }
// ------------------------------------------------------------
}  // end class StackX
////////////////////////////////////////////////////////////////
class Vertex
{
    public char label;        // label (e.g. 'A')
    public boolean wasVisited;
    // ------------------------------------------------------------
    public Vertex(char lab)   // constructor
    {
        label = lab;
        wasVisited = false;
    }
// ------------------------------------------------------------
}  // end class Vertex
////////////////////////////////////////////////////////////////
class Graph
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjacencyMatrix[][];      // adjacency matrix
    private int nVerts;          // current number of vertices
    private StackX theStack;
    // ------------------------------------------------------------
    public Graph()               // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int y=0; y<MAX_VERTS; y++)      // set adjacency
            for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
                adjacencyMatrix[x][y] = 0;
        theStack = new StackX();
    }  // end constructor
    // ------------------------------------------------------------
    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // ------------------------------------------------------------
    public void addEdge(int start, int end)
    {
        adjacencyMatrix[start][end] = 1;
    }
    // ------------------------------------------------------------
    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }
    // ------------------------------------------------------------
    public void dfs()  // depth-first search
    {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = true;  // mark it
            displayVertex(i);                 // display it
            theStack.push(i);                 // push it

            while( !theStack.isEmpty() )      // until stack empty,
            {
                // get an unvisited vertex adjacent to stack top
                int v = getAdjUnvisitedVertex( theStack.peek() );
                if(v == -1)                    // if no such vertex,
                    theStack.pop();
                else                           // if it exists,
                {
                    vertexList[v].wasVisited = true;  // mark it
                    displayVertex(v);                 // display it
                    theStack.push(v);                 // push it
                }
            }  // end while

            // stack is empty, so we're done
            for(int j=0; j<nVerts; j++)          // reset flags
                vertexList[j].wasVisited = false;
            System.out.println();
        }
    }  // end dfs

    public void makeTransitiveClosure() {
        System.out.println("Adjacency matrix...");
        showMatrix();
        for(int y = 0; y < nVerts; y++) {
            for (int x = 0; x < nVerts; x++) {
                if(adjacencyMatrix[y][x] == 1) {
                    for(int z = 0; z < nVerts; z++) {
                        if(adjacencyMatrix[z][y] == 1) {
                            adjacencyMatrix[z][x] = 1;
                        }
                    }
                }
            }
        }

        System.out.println("\nTransitive closure...");
        showMatrix();
    }

    private void showMatrix() {
        System.out.println();
        System.out.print("  ");
        for(int column = 0; column < nVerts; column++) {
            System.out.print(vertexList[column].label + " ");
        }
        System.out.println();
        for(int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + " ");
            for(int j = 0; j < nVerts; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------
    // returns an unvisited vertex adj to v
    public int getAdjUnvisitedVertex(int v)
    {
        for(int j=0; j<nVerts; j++)
            if(adjacencyMatrix[v][j]==1 && vertexList[j].wasVisited==false)
                return j;
        return -1;
    }  // end getAdjUnvisitedVertex()
// ------------------------------------------------------------
}  // end class Graph
////////////////////////////////////////////////////////////////
class DFSApp
{
    public static void main(String[] args)
    {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');    // 0  (start for dfs)
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('C');    // 2
        theGraph.addVertex('D');    // 3
        theGraph.addVertex('E');    // 4

        theGraph.addEdge(0, 2);     // AC
        theGraph.addEdge(1, 0);     // BA
        theGraph.addEdge(1, 4);     // BE
        theGraph.addEdge(4, 2);     // EC
        theGraph.addEdge(3, 4);     // DE

        theGraph.makeTransitiveClosure();

//        System.out.print("Connectivity Table: ");
//        theGraph.dfs();             // depth-first search
        System.out.println();
    }  // end main()
}  // end class DFSApp
////////////////////////////////////////////////////////////////
