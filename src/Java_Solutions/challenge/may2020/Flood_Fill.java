package challenge.may2020;

public class Flood_Fill {
    public static void main(String[] args) {
        Flood_Fill solution = new Flood_Fill();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        image = solution.floodFill(image, sr, sc, newColor);
        solution.printMatrix(image);
    }

    private void printMatrix(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.printf("%d ", image[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        floodFill(image, sr, sc, oldColor, newColor);
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        floodFill(image, sr, sc + 1, oldColor, newColor);
        floodFill(image, sr, sc - 1, oldColor, newColor);
        floodFill(image, sr + 1, sc, oldColor, newColor);
        floodFill(image, sr - 1, sc, oldColor, newColor);
    }

}
