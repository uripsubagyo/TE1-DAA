import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class TwoPivotBlock{
    // Source: https://www.geeksforgeeks.org/dual-pivot-quicksort/
    static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    static void dualPivotQuickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            List<Integer> pivots = partition(arr, low, high);
            dualPivotQuickSort(arr, low, pivots.get(0) - 1);
            dualPivotQuickSort(arr, pivots.get(0) + 1, pivots.get(1) - 1);
            dualPivotQuickSort(arr, pivots.get(1) + 1, high);
        }
    }

    static List<Integer> partition(List<Integer> arr, int low, int high) {
        if (arr.get(low) > arr.get(high)) {
            swap(arr, low, high);
        }

        int j = low + 1;
        int g = high - 1;
        int k = low + 1;
        int p = arr.get(low);
        int q = arr.get(high);

        while (k <= g) {
            if (arr.get(k) < p) {
                swap(arr, k, j);
                j++;
            } else if (arr.get(k) >= q) {
                while (arr.get(g) > q && k < g) {
                    g--;
                }
                swap(arr, k, g);
                g--;
                if (arr.get(k) < p) {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        swap(arr, low, j);
        swap(arr, high, g);

        List<Integer> pivotIndices = new ArrayList<>();
        pivotIndices.add(j);
        pivotIndices.add(g);

        return pivotIndices;
    }
}