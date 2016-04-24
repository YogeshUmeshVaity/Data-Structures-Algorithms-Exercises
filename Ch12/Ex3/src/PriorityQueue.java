public class PriorityQueue {
    private Heap heap;

    PriorityQueue(int maxSize) {
        heap = new Heap(maxSize);
    }

    public void insert(int item) {
        heap.insert(item);
    }

    public int remove() {
        return heap.remove().getKey();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(30);

        System.out.println("Insert:");
        for (int i = 0; i < 24; i++) {
            int key = (int) (Math.random() * 100);
            System.out.print(key + " ");
            priorityQueue.insert(key);
        }

        System.out.println("\nRemove:");
        for (int i = 0; i < 24; i++) {
            System.out.print(priorityQueue.remove() + " ");
        }
    }
}