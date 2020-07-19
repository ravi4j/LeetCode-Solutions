package challenge.july2020;

public class P005_Hamming_Distance {
    public static void main(String[] args) {
        P005_Hamming_Distance solution = new P005_Hamming_Distance();
        int x= 1;
        int y = 4;
        int result = solution.hammingDistance(x ,y);
        System.out.println(result);
    }

    public int hammingDistance(int x, int y) {
       int n =  x ^ y;
       int countBit = 0;
       while (n > 0){
           countBit += n & 1;
           n >>= 1;
       }
       return countBit;
    }

}
