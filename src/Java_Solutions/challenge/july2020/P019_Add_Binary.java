package challenge.july2020;

public class P019_Add_Binary {
    public static void main(String[] args) {
        P019_Add_Binary solution = new P019_Add_Binary();
        String a = "11";
        String b = "1";
        String result = solution.addBinary(a, b);
        System.out.println(result); // 100


        a = "1010";
        b = "1011";
        result = solution.addBinary(a, b);
        System.out.println(result); //     10101
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }

        int carry = 0;
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (lenA >= 0 || lenB >= 0) {
            int lsbA = 0;
            int lsbB = 0;
            if (lenA >= 0) {
                lsbA = a.charAt(lenA) == '0' ? 0 : 1;
                lenA--;
            }
            if (lenB >= 0) {
                lsbB = b.charAt(lenB) == '0' ? 0 : 1;
                lenB--;
            }
            int sum = lsbA + lsbB + carry;
            if (sum >= 2) {
                sb.append(String.valueOf(sum - 2));
                carry = 1;
            } else {
                sb.append(String.valueOf(sum));
                carry = 0;
            }
        }
        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();

    }
}
