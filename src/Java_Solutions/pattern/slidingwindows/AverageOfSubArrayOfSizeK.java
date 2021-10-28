package pattern.slidingwindows;

import java.util.Arrays;

public class AverageOfSubArrayOfSizeK {
    public static void main(String[] args) {
        AverageOfSubArrayOfSizeK solution = new AverageOfSubArrayOfSizeK();
        int[] input = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        double[] averages = solution.findAverageByBruteForce(input, K);
        System.out.println(Arrays.toString(averages));
        averages = solution.findAverageBySlidingWindow(input, K);
        System.out.println(Arrays.toString(averages));
    }

    public double[] findAverageByBruteForce(int[] inputs, int K) {
        double[] results = new double[inputs.length - K + 1];
        for (int i = 0; i <= inputs.length - K; i++) {
            double sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += inputs[j];
            }
            results[i] = sum / K;
        }
        return results;
    }

    public double[] findAverageBySlidingWindow(int[] inputs, int K) {
        double[] results = new double[inputs.length - K + 1];
        int windowStarts = 0;
        double windowSum = 0.0;
        for (int windowEnds = 0; windowEnds < inputs.length; windowEnds++) {
            windowSum += inputs[windowEnds];
            // Slide Window
            if (windowEnds >= K - 1) {
                results[windowStarts] = windowSum / K;
                windowSum -= inputs[windowStarts];
                windowStarts++;
            }
        }
        return results;
    }

}
