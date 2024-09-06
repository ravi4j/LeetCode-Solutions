package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P00149_Max_Points_On_A_Line {
    public static void main(String[] args) {
        P00149_Max_Points_On_A_Line solution = new P00149_Max_Points_On_A_Line();
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        int result = solution.maxPoints(points);
        System.out.println(result);

        points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        result = solution.maxPoints(points);
        System.out.println(result);

        points = new int[][]{{-240, -657}, {-27, -188}, {-616, -247}, {-264, -311}, {-352, -393}, {-270, -748}, {3, 4},
                {-308, -87}, {150, 526}, {0, -13}, {-7, -40}, {-3, -10}, {-531, -892}, {-88, -147}, {4, -3}, {-873, -555},
                {-582, -360}, {-539, -207}, {-118, -206}, {970, 680}, {-231, -47}, {352, 263}, {510, 143}, {295, 480},
                {-590, -990}, {-236, -402}, {308, 233}, {-60, -111}, {462, 313}, {-270, -748}, {-352, -393}, {-35, -148},
                {-7, -40}, {440, 345}, {388, 290}, {270, 890}, {10, -7}, {60, 253}, {-531, -892}, {388, 290}, {-388, -230},
                {340, 85}, {0, -13}, {770, 473}, {0, 73}, {873, 615}, {-42, -175}, {-6, -8}, {49, 176}, {308, 222},
                {170, 27}, {-485, -295}, {170, 27}, {510, 143}, {-18, -156}, {-63, -316}, {-28, -121}, {396, 304}, {472, 774},
                {-14, -67}, {-5, 7}, {-485, -295}, {118, 186}, {-154, -7}, {-7, -40}, {-97, -35}, {4, -9}, {-18, -156},
                {0, -31}, {-9, -124}, {-300, -839}, {-308, -352}, {-425, -176}, {-194, -100}, {873, 615}, {413, 676},
                {-90, -202}, {220, 140}, {77, 113}, {-236, -402}, {-9, -124}, {63, 230}, {-255, -118}, {472, 774},
                {-56, -229}, {90, 228}, {3, -8}, {81, 196}, {970, 680}, {485, 355}, {-354, -598}, {-385, -127}, {-2, 7},
                {531, 872}, {-680, -263}, {-21, -94}, {-118, -206}, {616, 393}, {291, 225}, {-240, -657}, {-5, -4}, {1, -2}, {485, 355},
                {231, 193}, {-88, -147}, {-291, -165}, {-176, -229}, {154, 153}, {-970, -620}, {-77, 33}, {-60, -111}, {30, 162}, {-18, -156},
                {425, 114}, {-177, -304}, {-21, -94}, {-10, 9}, {-352, -393}, {154, 153}, {-220, -270}, {44, -24}, {-291, -165}, {0, -31},
                {240, 799}, {-5, -9}, {-70, -283}, {-176, -229}, {3, 8}, {-679, -425}, {-385, -127}, {396, 304}, {-308, -352}, {-595, -234},
                {42, 149}, {-220, -270}, {385, 273}, {-308, -87}, {-54, -284}, {680, 201}, {-154, -7}, {-440, -475}, {-531, -892}, {-42, -175},
                {770, 473}, {118, 186}, {-385, -127}, {154, 153}, {56, 203}, {-616, -247}};
        result = solution.maxPoints(points);
        System.out.println(result);
    }

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Point[] pointArray = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointArray[i] = new Point(points[i][0], points[i][1]);
        }
        return maxPoints(pointArray);
    }

    public int maxPoints(Point[] points) {
        int result = 0;
        Map<Integer, Map<Integer, Integer>> slopLookUp = new HashMap<>();
        for (int i = 0; i < points.length; i++) {

            slopLookUp.clear();
            int overlap = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                // simplify slop x and y
                int gcd = gcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if (slopLookUp.containsKey(x)) {
                   /* if(slopLookUp.get(x).containsKey(y)){
                        slopLookUp.get(x).put(y, slopLookUp.get(x).get(y) + 1);
                    } else {
                        slopLookUp.get(x).put(y , 1);
                    } */
                    slopLookUp.get(x).merge(y, 1, Integer::sum);
                } else {
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(y, 1);
                    slopLookUp.put(x, map);
                }
                max = Math.max(max, slopLookUp.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    private class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
