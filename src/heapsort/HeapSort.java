package heapsort;

public class HeapSort {

    public static void heapSort(int[] v) {
        buildMaxHeap(v);
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n);
        }
    }

    private static void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }
    }

    private static void maxHeapify(int[] v, int pos, int n) {
        int maxi;
        int l = 2 * pos + 1;
        int right = 2 * pos + 2;
        if ((l < n) && (v[l] > v[pos])) {
            maxi = l;
        } else {
            maxi = pos;
        }
        if (right < n && v[right] > v[maxi]) {
            maxi = right;
        }
        if (maxi != pos) {
            swap(v, pos, maxi);
            maxHeapify(v, maxi, n);
        }
    }

    public static void swap(int[] v, int j, int aposJ) {
        int aux = v[ j];
        v[ j] = v[ aposJ];
        v[ aposJ] = aux;
    }
    
    public static void print(int[] v){
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] v = {33,2,22,1,99,31,54,5};
        print(v);
        System.out.println("\n");
        heapSort(v);
        print(v);
    }

}
