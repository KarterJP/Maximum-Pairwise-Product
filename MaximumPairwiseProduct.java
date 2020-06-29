import java.util.*;
import java.io.*;

public class MaximumPairwiseProduct {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.printf("%.0f\n", getMaxPairwiseProduct(numbers));
    }

    static double getMaxPairwiseProduct(int[] numbers) {
        double max_product = 0;
        double max_num1 = 0;
        double max_num2 = 0;

        for (double number : numbers) {
            if (number > max_num1) {
                max_num2 = max_num1;
                max_num1 = number;
            } else if (number > max_num2) {
                max_num2 = number;
            }
        }
        max_product = max_num1 * max_num2;

        return max_product;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}

