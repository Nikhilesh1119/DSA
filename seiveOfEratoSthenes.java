import java.util.Arrays;

public class seiveOfEratoSthenes {
    public static void main(String[] args) {
        boolean isPrime[] = isPrime(20);
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == true)
                System.out.println(i + " is Prime ");
        }

        System.out.println(gcd(2520, 4540));
    }

    static boolean[] isPrime(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

    static int gcd(int a, int b) {
        // if(b==0) return a;
        // return gcd(b, a%b);
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
