package challenge.may2020;

public class Valid_Perfect_Square {
    public static void main(String[] args) {
        Valid_Perfect_Square solution = new Valid_Perfect_Square();
        int num = 16;
        boolean result = solution.isPerfectSquare(num);
        System.out.println(result);

        num = 144;
        result = solution.isPerfectSquare(num);
        System.out.println(result);

    }

    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num <= 1) return true;
        int i = 2;
        int j = num;
        while (i <= j) {
            long k = i + (j - i) / 2; // avoid integer overflow
            if (k * k == num) return true;
            if (k * k > num) {
                j = (int) k - 1;
            } else {
                i = (int) k + 1;
            }
        }
        return false;
    }
}
