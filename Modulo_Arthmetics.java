public class Modulo_Arthmetics {
    public static void main(String[] args) {
        System.out.println(fastPower(2348535, 456, 1000000007));
    }

    static long fastPower(long a, long b, int n) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = (res % n * a % n) % n;
            }
            a = (a % n * a % n) % n;
            b = b >> 1;
        }
        return res;
    }
}


// Some other topics are BigInteger, Catalan Number,Pigeon hole Principal, Inclusive-Exclusion