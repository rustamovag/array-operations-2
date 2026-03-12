import java.util.Arrays;

public class ArrayOperationsAdvanced {

    // Merge two sorted arrays
    static int[] mergeSorted(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i=0, j=0, k=0;
        while (i<a.length && j<b.length) res[k++] = (a[i]<=b[j]) ? a[i++] : b[j++];
        while (i<a.length) res[k++] = a[i++];
        while (j<b.length) res[k++] = b[j++];
        return res;
    }

    // Remove duplicates (preserving order)
    static int[] removeDuplicates(int[] arr) {
        boolean[] seen = new boolean[1001];
        int count = 0;
        for (int n : arr) if (!seen[n]) { seen[n] = true; count++; }
        int[] res = new int[count]; int idx = 0;
        for (int n : arr) if (seen[n]) { seen[n] = false; res[idx++] = n; }
        return res;
    }

    // Second largest element
    static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > first)        { second = first; first = n; }
            else if (n > second)  { second = n; }
        }
        return second;
    }

    // Rotate array by k positions
    static int[] rotateRight(int[] arr, int k) {
        int n = arr.length; k %= n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[(i + k) % n] = arr[i];
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9}, b = {2,4,6,8,10};
        System.out.println("Merge sorted:");
        System.out.println("  " + Arrays.toString(a) + " + " + Arrays.toString(b));
        System.out.println("  = " + Arrays.toString(mergeSorted(a, b)));

        int[] withDups = {3,1,4,1,5,9,2,6,5,3,5};
        System.out.println("\nRemove duplicates:");
        System.out.println("  Before: " + Arrays.toString(withDups));
        System.out.println("  After : " + Arrays.toString(removeDuplicates(withDups)));

        int[] data = {12, 35, 1, 10, 34, 1};
        System.out.println("\nSecond largest in " + Arrays.toString(data) + " = " + secondLargest(data));

        int[] arr = {1,2,3,4,5,6,7};
        System.out.println("\nRotate " + Arrays.toString(arr) + " by 3:");
        System.out.println("  → " + Arrays.toString(rotateRight(arr, 3)));
    }
}
