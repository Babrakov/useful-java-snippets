package ru.infoza.quicksort;

public class QuickSortAlgorithm {
    public static void main(String[] args) {

        int[] arr = {64, 34, 25, 12, 22, 11, 90, 38};

        System.out.println("Source array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Quick sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            // Recursively sort arrays before and after pivot
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Search a pivot and move all smaller than pivot to the left and larger elements to the right
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Use the last element as the pivot
        int i = (low - 1); // Lower element index

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Auxiliary method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
