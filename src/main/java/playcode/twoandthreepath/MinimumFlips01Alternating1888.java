package playcode.twoandthreepath;

public class MinimumFlips01Alternating1888 {

    public int minFlips(String s) {
        int size = s.length();
        int[] left0 = new int[size];
        int[] left1 = new int[size];
        int[] right0 = new int[size];
        int[] right1 = new int[size];

        char[] chars = s.toCharArray();
        // the precedence of the tenary operation
        for (int i = 0; i < size; i++) {
            // 1100 size =4;
            boolean isOne = chars[i] == '1';
            if (i % 2 == 0) {
                left0[i] = (isOne ? 1 : 0) + (i == 0 ? 0 : left0[i - 1]);
                left1[i] = (isOne ? 0 : 1) + (i == 0 ? 0 : left1[i - 1]);
            } else { //idx1
                left1[i] = (isOne ? 1 : 0) + (i == 0 ? 0 : left1[i - 1]);
                left0[i] = (isOne ? 0 : 1) + (i == 0 ? 0 : left0[i - 1]);
            }
            //System.out.println(i + " i: " + left0[i] + " " + left1[i] );
        }
        for (int i = size-1; i >= 0; i--) {
            //0011 size = 4; 4-0-1 =3
            boolean isOne = chars[i] == '1';
            if ((size - i - 1) % 2 == 0) {
                right0[i] = (isOne ? 1 : 0) + (i == size - 1 ? 0 : right0[i + 1]);
                right1[i] = (isOne ? 0 : 1) + (i == size - 1 ? 0 : right1[i + 1]);
            } else { //idx1
                right1[i] = (isOne ? 1 : 0) + (i == size - 1 ? 0 : right1[i + 1]);
                right0[i] = (isOne ? 0 : 1)+ (i == size - 1 ? 0 : right0[i + 1]);

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            min = Math.min(min, left0[i] + (i == size - 1 ? 0 : right1[i + 1]));
            min = Math.min(min, left1[i] + (i == size - 1 ? 0 : right0[i + 1]));
        }
        return min;
    }
}
