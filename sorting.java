public class sorting {
    public static void main(String[] args) {
        int a[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // mergeSort(a, 0, a.length - 1);
        // for (int i = 0; i < a.length; i++) {
        // System.out.print(a[i] + " ");
        // }

        // quickSort(a, 0, a.length - 1);
        // for (int i = 0; i < a.length; i++) {
        // System.out.print(a[i] + " ");
        // }
    }

    static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    static void merge(int a[], int l, int mid, int h) {
        int[] b = new int[h - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= h) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= h) {
                b[k] = a[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }
        for (int x = 0; x < b.length; x++) {
            a[l + x] = b[x];
        }
    }

    static void quickSort(int a[], int l, int h) {
        if (l < h) {
            int pivot = partition(a, l, h);
            quickSort(a, l, pivot - 1);
            quickSort(a, pivot + 1, h);
        }
    }

    static int partition(int a[], int l, int h) {
        int pivot = a[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, h);
        return i + 1;
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
