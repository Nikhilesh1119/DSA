public class Recursion {
    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "abc";
        System.out.println(matrixWays(4, 7));
        System.out.println(josephus(4, 3));
        System.out.println(palindrome(s1, 0, s1.length()-1));
        Powerset(s2, 0, "");
        Permutation(s2, 0, s2.length() - 1);
        
    }

    static int matrixWays(int n, int m) {
        if (n == 1 || m == 1)
            return 1;
        return matrixWays(n - 1, m) + matrixWays(n, m - 1);
    }

    static int josephus(int n, int k) {
        if (n == 1)
            return 0;

        return (josephus(n - 1, k) + k) % n;
    }

    static boolean palindrome(String s, int l, int r) {
        if (l >= r)
            return true;
        if (s.charAt(l) != s.charAt(r))
            return false;
        return palindrome(s, l + 1, r - 1);
    }

    static void Powerset(String s, int i, String current) {
        if (i == s.length()) {
            System.out.println(current);
            return;
        }
        Powerset(s, i + 1, current + s.charAt(i));
        Powerset(s, i + 1, current);
    }

    static void Permutation(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
            return;
        }
        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            Permutation(s, l + 1, r);
            s = swap(s, l, i);
        }
    }

    static String swap(String str, int i, int j) {
        char[] s = str.toCharArray();
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return new String(s);
    }

}
