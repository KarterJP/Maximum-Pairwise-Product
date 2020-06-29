import java.util.*;
import java.io.*;

public class MaximumPairwiseProduct {
    static double getMaxPairwiseProduct(int[] numbers) {
        double max_product = 0;
        double n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    public static void main(String[] args) {
//        while(true) {
//            int n = (int)(Math.random() * 10 + 2);
//            int[] numbers = new int[n];
//            for (int i = 0; i < n; i++) {
//                numbers[i] = (int)(Math.random() * 10);
//            }
//            double slowMax = getMaxPairwiseProduct(numbers);
//            double fastMax = getMaxPairwiseProductFast(numbers);
//            System.out.println(n);
//            System.out.println(Arrays.toString(numbers));
//            System.out.println(fastMax + "   " + slowMax);
//            System.out.println("-----------------------------------------------------");
//            if (fastMax != slowMax) {
//                break;
//            }
//        }
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.printf("%.0f\n", getMaxPairwiseProductFast(numbers));
    }

    static double getMaxPairwiseProductFast(int[] numbers) {
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

