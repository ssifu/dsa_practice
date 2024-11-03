import java.util.ArrayList;

public class RecursionPractice {

    public static int fact(int n) {
        if (n == 1)
            return 1;
        return n * fact(n - 1);
    }

    public static void swapArray(int[] arr, int left, int right) {
        if (left > right)
            return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        swapArray(arr, left + 1, right - 1);
    }

    public static boolean checkPalindrome(String str, int left) {
        if (str.charAt(left) != str.charAt(str.length() - left - 1))
            return false;
        if (left >= str.length() - left - 1)
            return true;

        return checkPalindrome(str, left + 1);
    }

    public static void printAllSequence(ArrayList<Integer> list, int[] arr, int index) {
        if (index == arr.length) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }
        list.add(arr[index]);
        printAllSequence(list, arr, index + 1);
        list.remove(arr[index]);
        printAllSequence(list, arr, index + 1);
    }

    public static void main(String[] args) {
        // System.out.println(fact(4));

        // int[] arr = new int[] { 1, 2, 3, 4 };
        // swapArray(arr, 0, arr.length - 1);
        // for (int num : arr) {
        // System.err.println(num);
        // }

        // String str = "asdlkfjadslfkjdas";
        // System.out.println(checkPalindrome(str, 0));

        int[] arr = new int[] { 3, 2, 1 };
        printAllSequence(new ArrayList<Integer>(), arr, 0);
    }
}