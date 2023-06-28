
public class Arrays {
    public static void main(String[] args) {
        int a[] = { 1, 2, 5, 5, 5, 2, 1, 5, 5 };
        int b[] = { 5, -4, -2, 6, -1 };
        int c[] = { 5, 2, 7, 3, 6, 1, 2, 4 };
        // System.out.println(Majorelement(a));
        // System.out.println(largestSum(b));
        // System.out.println(buyAndSell2(c));
        // System.out.println(tappingRainWater(c));
    }

    static int Majorelement(int a[]) {
        int j = 0, c = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[j])
                c++;
            else
                c--;
            if (c == 0) {
                j = a[i];
                c = 1;
            }
        }
        return j;
    }

    static int largestSum(int a[]) {
        int max = 0, c = 0;
        for (int i = 0; i < a.length; i++) {
            c += a[i];
            if (c > max) {
                max = c;
            }
            if (c < 0) {
                c = 0;
            }
        }
        return max;
    }

    static int buyAndSell2(int a[]) {
        int profit = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1])
                profit += a[i] - a[i - 1];
        }
        return profit;
    }

    static int tappingRainWater(int a[]) {
        int left[] = new int[a.length];
        int right[] = new int[a.length];
        left[0] = a[0];
        right[a.length - 1] = a[a.length - 1];
        int ans = 0;
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], a[i]);
        }
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            ans += Math.min(left[i], right[i]) - a[i];
        }
        return ans;
    }
}
