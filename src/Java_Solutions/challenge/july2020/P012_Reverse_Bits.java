package challenge.july2020;

public class P012_Reverse_Bits {
    public static void main(String[] args) {
        P012_Reverse_Bits solution = new P012_Reverse_Bits();
        int n = 0b00000010100101000001111010011100;
        int result = solution.reverseBits(n);
        System.out.println(solution.toBinaryString(result)); // 00111001011110000010100101000000


        n = 0b11111111111111111111111111111101;
        result = solution.reverseBits(n);
        System.out.println(solution.toBinaryString(result)); //10111111111111111111111111111111

    }

    private String toBinaryString(int n){
        return String.format("%32s" , Integer.toBinaryString(n)).replaceAll( " " , "0");
    }

    public int reverseBits(int n) {
        int SIZE = Integer.SIZE - 1;
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, SIZE - i);
        }
        return n;
    }

    private int swapBits(int x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            int bitmask = (1 << i) | (1 << j);
            x ^= bitmask;
        }
        return x;
    }
}
