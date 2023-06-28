import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        int a[] = { 1, 8, 4, 5, 9, 3 };
        int b[] = { 9, 4, 2, 8, 1, 7 };
        int c[] = { 1, 2, 2, 1, 3, 1, 1, 3 };
        // union(a, b);
        // intersection(a, b);
        // subArrayOfSum(a, 9);
        // subArrayOfSum(a, 6);
        // distintElement(c, 4);
    }

    static void union(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            set.add(i);
        }
        for (int i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void intersection(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            if (set.contains(i)) {
                set.remove(i);
                ans.add(i);
            }
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void subArrayOfSum(int a[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, start = 0, end = -1;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum - k == 0) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(sum - k)) {
                start = map.get(sum - k) + 1;
                end = i;
                break;
            }
            map.put(sum, i);
        }
        if (end == -1) {
            System.out.println("not found");
        } else {
            System.out.println("found");
        }
    }

    static void distintElement(int a[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        System.out.println(map.size());
        for (int i = k; i < a.length; i++) {
            if (map.get(a[i - k]) == 1) {
                map.remove(a[i - k]);
            } else {
                map.put(a[i - k], map.getOrDefault(a[i - k], 0) - 1);
            }
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            System.out.println(map.size());
        }
    }
}
