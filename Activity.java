import java.util.Arrays;
import java.util.Scanner;

public class SearchAlgorithms {

    // Linear Search with Iteration Count
    public static int linearSearch(int[] array, int target) {
        int iterations = 0;
        for (int i = 0; i < array.length; i++) {
            iterations++;
            if (array[i] == target) {
                System.out.println("Linear Search Iterations: " + iterations);
                return i;
            }
        }
        System.out.println("Linear Search Iterations: " + iterations);
        return -1;
    }

    // Recursive Binary Search
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] > target) {
            return binarySearch(array, target, left, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, right);
        }
    }

    // Error Handling for Input Array
    public static int[] getInputArray(Scanner scanner) {
        System.out.println("Enter the array elements separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        try {
            for (int i = 0; i < input.length; i++) {
                array[i] = Integer.parseInt(input[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integer values only.");
            return null;
        }
        return array;
    }

    // Error Handling for Target Input
    public static int getInputTarget(Scanner scanner) {
        System.out.println("Enter the target value:");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer value.");
            return Integer.MIN_VALUE;
        }
    }

    // Performance Comparison between Linear and Binary Search
    public static void comparePerformance(int[] array, int target) {
        long startTime, endTime;

        startTime = System.nanoTime();
        linearSearch(array, target);
        endTime = System.nanoTime();
        System.out.println("Linear Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        binarySearch(array, target);
        endTime = System.nanoTime();
        System.out.println("Binary Search Time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = getInputArray(scanner);

        // Check for null or empty array input
        if (array == null || array.length == 0) {
            System.out.println("Invalid array input. Exiting program.");
            return;
        }

        int target = getInputTarget(scanner);
        if (target == Integer.MIN_VALUE) {
            System.out.println("Invalid target input. Exiting program.");
            return;
        }

        Arrays.sort(array); // Ensure array is sorted for binary search
        System.out.println("Array sorted for binary search.");

        comparePerformance(array, target);
    }
}
