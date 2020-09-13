package challenge.july2020;

public class P027_Add_Digits {
    public static void main(String[] args) {
        P027_Add_Digits solution = new P027_Add_Digits();
        int num = 38;
        int result = solution.addDigits(num);
        System.out.println(result);
    }

    public int addDigits(int num) {
        return add(num, 10);
    }

    private int add(int num, int base) {
        int total = 0;
        while (num > 0 || total > 9) {
            if (num == 0) {
                num = total;
                total = 0;
            }
            total += num % base;
            num /= base;
        }
        return total;
    }
}
