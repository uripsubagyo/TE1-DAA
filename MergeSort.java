import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    // source: https://www.geeksforgeeks.org/merge-sort/
    // Perubahan list to arrayList


    static void merge(List<Integer> arr, int l, int m, int r) {
        // Find sizes of two sublists to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp lists
        List<Integer> L = new ArrayList<>(Collections.nCopies(n1, 0));
        List<Integer> R = new ArrayList<>(Collections.nCopies(n2, 0));

        // Merge the temp lists

        // Initial indices of the first and second sublists
        int i = 0, j = 0;

        // Initial index of the merged sublist
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }
        // Copy remaining elements of L if any
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }
        // Copy remaining elements of R if any
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr.subList(l, r+1) using merge()
    static void sort(List<Integer> arr, int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort the first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}
