import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        int a[] = { 6, 8, 3, 4, 9, 2, 1, 7, 5 };
        Heap median = new Heap();
        // System.out.println(kLargest(a,4));
        // System.out.println(NRopes(a));
        // for (int i = 0; i < a.length; i++) {
        // median.insertNum(a[i]);
        // System.out.println(median.medianOfArray());
        // }
    }

    static int kLargest(int a[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(a[i]);
        }
        for (int i = k; i < a.length; i++) {
            if (pq.peek() < a[i]) {
                pq.poll();
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }

    static int NRopes(int a[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }
        int ans = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            ans += sum;
            pq.add(ans);
        }
        return ans;
    }

    public double medianOfArray() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return maxHeap.peek();
    }

    public void insertNum(int n) {
        if (maxHeap.isEmpty() || maxHeap.peek() > n) {
            maxHeap.add(n);
        } else {
            minHeap.add(n);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
