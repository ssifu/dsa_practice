public class Stack {
    private int[] arr;
    private int topIndex;

    public Stack() {
        this.arr = new int[10];
        this.topIndex = 0;
    }

    public void push(int data) {
        if (topIndex >= arr.length) {
            System.err.println("Stack is full");
            return;
        }
        arr[topIndex] = data;
        ++topIndex;
    }

    public int pop() {
        if (topIndex <= 0) {
            System.err.println("Stack is empty");
            return -1;
        }
        --topIndex;
        return arr[topIndex];
    }

    public int top() {
        if (topIndex <= 0) {
            System.err.println("Stack is empty");
            return -1;
        }
        return arr[topIndex - 1];
    }

    public int size() {
        return topIndex;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(6);
        stack.push(7);

        System.err.println("Size: " + stack.size());

        System.err.println(stack.pop());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.err.println(stack.top());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
        System.err.println(stack.pop());
    }
}
