import java.util.Arrays;

public class CustomArrayList {

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int number) {
        if (this.isFull()) {
            this.resize();
        }
        data[size++] = number;
    }

    private boolean isFull() {
        return size == this.data.length;
    }

    private void resize() {
        int[] temp = new int[this.data.length * 2];

        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    public int remove() {
        int removed = data[--size];
        return removed;
    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" + "data=" + Arrays.toString(data) + ", size=" + size + "}";
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        for (int i = 0; i < 14; i++) {
            list.add(i + 1);
        }
        System.out.println(list);
    }
}
