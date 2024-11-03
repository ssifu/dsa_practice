package Sorting;

public class Main {
    public static void main(String[] args) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        int[] arr = new int[] { 5, 2, 8, 1, 7, 4, 6, 3 };
        System.err.print("Unsorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.err.println();
        // sortingAlgorithms.bubbleSort(arr);
        // sortingAlgorithms.selectionSort(arr);
        // sortingAlgorithms.insertionSort(arr);
        // sortingAlgorithms.mergeSort(arr, 0, arr.length - 1);
        // sortingAlgorithms.quickSort(arr, 0, arr.length - 1);
        // arr = sortingAlgorithms.countSort(new int[] { 2, 1, 1, 0, 2, 5, 4, 0, 2, 8,
        // 7, 7, 9, 2, 0, 1, 9 });
        sortingAlgorithms.countSort(arr);
        System.err.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
