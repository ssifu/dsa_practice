package Sorting;

import java.util.ArrayList;

public class SortingAlgorithms {

    /*******************************************
     * 
     * BUBBLE SORT
     * 
     * - Get the maximum value
     * - And put it to the last position by swapping adjacent values
     * - TO = O(n^2) for worst and average case, best case O(n), happens when every
     * element is sorted
     * 
     *******************************************/

    public void bubbleSort(int[] arr) {
        int n = arr.length;

        // i = 0 -> n - 1 because we are always putting the maximum value at the end
        // So no need to check for the maximum
        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            // j = 0 -> n - i - 1 because as the previous reason.
            // No need to go through the maximum values
            for (int j = 0; j < n - i - 1; j++) {

                // Swapping the two adjacent value if left one is greather than the right one
                // By this the maximum value in the array will go to the last of the array.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    /*******************************************
     * 
     * SELECTION SORT
     * 
     * - Get the minimum value (minimum values index) in each iteration
     * - Put it into the current index position
     * - TO = O(n^2) for every case
     * 
     *******************************************/

    public void selectionSort(int[] arr) {
        int n = arr.length;

        // Loop the array from 0 -> n - 1 and put the minimum value in ith index
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Loop through the array from i -> n and find the minimum values index
            for (int j = i; j < n; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }

    /*******************************************
     * 
     * INSERTION SORT
     * 
     * - Take an element and place it in it's correct position
     * - Take an element and swap with the elements to the left until swapping can't
     * happen
     * - TO = O(n^2) for worst and average case, best case O(n), happens when every
     * element is sorted
     * 
     *******************************************/

    public void insertionSort(int[] arr) {
        int n = arr.length;

        // Check for every value
        for (int i = 0; i < n; i++) {

            // Take that value and put it in it's correct position by shifting every value
            // to it's right or by swapping values to the left until it cannot be swapped
            // anymore
            for (int j = i; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }

        }
    }

    /*******************************************
     * 
     * MERGE SORT
     * 
     * - Divide the array into two separate array each time until it cannot be
     * divided anymore
     * - Then merge the array with sorting the smaller arrays
     * 
     * - TO = O(nlogn), because we are dividing the array and every time we are
     * dividing the array size becomes n/2 and thus we can say the time complexity
     * is logn.
     * And in the merge part for the worst time of the merge we need to iterate
     * through the whole array and add the sorted values which is O(n)
     * So the final time complexity is O(nlogn)
     * 
     * - SC = O(n) for extra temporary array
     * 
     *******************************************/

    public void mergeSort(int[] arr, int low, int high) {

        // Base case
        // Only happens when the array cannot be divided anymore
        if (low == high)
            return;

        // Taking the mid index to divide the array
        int mid = (low + high) / 2;

        // As we can't logically break an array, we are sending indexes to mention the
        // breakpoints. Here, (low, mid) 1 array and (mid + 1, high) other array

        mergeSort(arr, low, mid); // First part of the array to divide from low to mid
        mergeSort(arr, mid + 1, high); // Second part of the array to divide from mid + 1 to high

        this.merge(arr, low, mid, high); // After dividing the array merge it back together
    }

    private void merge(int[] arr, int low, int mid, int high) {

        // Taking a temporary array to store the values
        ArrayList<Integer> temp = new ArrayList<>();

        // Here left is the first index of the first array
        // right is the first index of the second array
        int left = low, right = mid + 1;

        // Compare between the two arrays and add the values in the temp array sorted
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // After finished comparing if one of the array still has some values just add
        // them at the last of the temp array as they are already sorted (or came sorted
        // merged)
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Add the values back to the original array
        for (int i = low; i <= high; i++) {
            // As temp always starts from 0, we can make index like (i - low) like that it
            // will become:
            // low - low = 0
            // low + 1 - low = 1
            // low + 2 - low = 2 and so on
            arr[i] = temp.get(i - low);
        }
    }

    /*******************************************
     * 
     * QUICK SORT
     * 
     * - Take a pivot (1st element in this case)
     * - Put it in it's position and make the left part of the array smaller than
     * the pivot and the right part greater than the pivot
     * - Do it again and again
     * 
     * - TO = O(nlogn) like merge sort
     * - SC = O(1)
     * 
     * - Worst case TO will be O(n^2)
     * - Worst case happens when the array is sorted ascending and descending
     * - If we choose the first element of the pivot and the array is sorted in
     * ascending order, left portion of the pivot will be empty and the next
     * iteration will be on the right portion which consecutively contains (n-1),
     * (n-2), (n-3), ...., 1 element.
     * So, the time complexity will be n + (n-1) + (n-2) + ... = n(n+1)/2 = O(n^2)
     * 
     *******************************************/

    public void quickSort(int arr[], int low, int high) {
        // If low < high then the quick sort will happen
        // Because when the array gets divided into one array (low = high) it is
        // already sorted
        if (low < high) {
            // Get the partionIndex
            int partitionIndex = this.partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1); // Run quicksort for the left portion of the partition index
            quickSort(arr, partitionIndex + 1, high); // Run quicksort for the right portion of the partition index
        }
    }

    private int partition(int arr[], int low, int high) {

        // Get the pivot
        int pivot = arr[low];

        // Take two pointer at the start and end of the array
        int i = low;
        int j = high;

        // Run through the array until the pointer crosses each other and swap the
        // values to make the left portion smaller and the right portion bigger than the
        // pivot
        while (i < j) {

            // It will stop when it finds a bigger than pivot element on the left
            while (arr[i] <= pivot && i < high) {
                i++;
            }

            // It will stop when it finds a smaller than pivot element on the right
            while (arr[j] > pivot && j > low) {
                j--;
            }

            // If they did not cross each other meaning they both found element to swap,
            // swap the elements
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // When the above loop ends 'j' will end up in the last index of the left
        // portion, which is basically the position for the pivot element
        // Now swap the pivot with the last index of the portion
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        // Return the pivot index as we know that j is currently in the pivot index
        return j;
    }

    /*******************************************
     * 
     * COUNT SORT
     * 
     * - This is not a comparison sort, so we don't compare values
     * - We sort the array according to the key value given
     * - Basically get the range of the array values, then key = high value of the
     * range.
     * - Then get an array of the size of the key value + 1 and then store the
     * frequency of the distince elements into that array
     * - Then get the prefix sum of the array
     * - Then loop through the original array from the last, get the prefix sum - 1
     * value from the prefix sum array and put the element in that index
     * 
     * - TO = O(n + k)
     * 
     * - k has to be O(n) and cannot be approximately O(n^2)
     * - Won't work on negative values (maybe after some normalization)
     * -
     * 
     *******************************************/

    public void countSort(int arr[]) {
        int n = arr.length;

        int k = arr[0];
        // Finding the maximum
        for (int i = 0; i < n; i++) {
            k = Math.max(arr[i], k);
        }

        // Taking the count array which will store the frequency of every distince
        // elements
        int[] count = new int[k + 1];

        for (int i = 0; i < n; i++) {
            ++count[arr[i]];
        }

        // Taking prefix sum of the count array
        for (int i = 1; i <= k; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Taking the output array to store sorted values
        int[] output = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            output[--count[arr[i]]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

}

// [5, 2, 8, 1, 7, 4, 6, 3]
