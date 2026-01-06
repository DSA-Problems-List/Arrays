import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class IndexesOfSubarraySum {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int s = 0, curr = 0;
        for (int e = 0; e < arr.length; e++) {
            curr += arr[e];
            while (curr > target && s <= e) curr -= arr[s++];
            if (curr == target) return new ArrayList<>(Arrays.asList(s + 1, e + 1));
        }
        return new ArrayList<>(Arrays.asList(-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // Call method and print result
        ArrayList<Integer> result = subarraySum(arr, target);
        System.out.println("Result: " + result);

        sc.close();
    }
}