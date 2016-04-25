public class PriorityQueue {
    private Tree heap;

    PriorityQueue() {
        heap = new Tree();
    }

    public void insert(int item) {
        heap.insert(item);
    }

    public int remove() {
        return heap.removeMax();
    }

    public void change(int oldValue, int newValue) {
        heap.delete(oldValue);
        heap.insert(newValue);

    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.insert(60);

        System.out.println("Insert:");
        for (int i = 0; i < 24; i++) {
            int key = (int) (Math.random() * 100);
            System.out.print(key + " ");
            priorityQueue.insert(key);
        }
        System.out.println();
        System.out.println("change(60, 39)");

        priorityQueue.change(60, 39);

        System.out.println("\nRemove:");
        for (int i = 0; i < 25; i++) {
            System.out.print(priorityQueue.remove() + " ");
        }
    }
}