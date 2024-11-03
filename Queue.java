public class Queue {
    private int[] queue;
    private int current;
    private int first;

    public Queue() {
        this.current = 0;
        this.first = 0;
        this.queue = new int[10];
    }

    public void add(int data) {
        if (this.current >= queue.length) {
            System.err.println("Queue is full");
            return;
        }
        queue[this.current] = data;
        ++this.current;
    }

    public int poll() {
        if (this.first == this.current) {
            System.err.println("Queue is empty");
            return -1;
        }
        return queue[first++];
    }

    public int peek() {
        if (this.first == this.current) {
            System.err.println("Queue is empty");
            return -1;
        }
        return queue[first];
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(8);
        queue.add(8);
        queue.add(8);
        queue.add(8);

        System.err.println(queue.poll());
        System.err.println(queue.poll());
        System.err.println(queue.poll());
        System.err.println(queue.poll());
        System.err.println(queue.poll());
        System.err.println(queue.poll());
        System.err.println(queue.poll());
        System.err.println(queue.poll());
        System.err.println(queue.poll());
    }
}
