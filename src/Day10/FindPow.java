package Day10;

public class FindPow {
    public double myPow(double x, int n) {
        long N = n;
     
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return pow(x, N);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        
        if (n % 2 == 1) {
            return x * pow(x, n - 1);
        }
        return pow(x * x, n / 2);
    }

    public static void main(String[] args) {
        FindPow solution = new FindPow();
        
        double x = 2;
        int n = 10;
        double result = solution.myPow(x, n);
        
        System.out.println("Result (2^10): " + result);
        System.out.println("Result (2^-2): " + solution.myPow(2, -2)); 
        System.out.println("Result (2^Integer.MIN_VALUE): " + solution.myPow(2, Integer.MIN_VALUE));
    }
}
