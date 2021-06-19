package playcode;

import java.util.*;

public class Playground {
    public static boolean findRotation(int[][] mat, int[][] target) {

        // max number of rotations is 4 --> 360 degrees

        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) //Checking two matrices are equal or not.
                return true;
            mat = rotateMatrix(mat);
        }
        return false;
    }
    // function to rotate the matrix.
    public static int[][] rotateMatrix(int[][] mat) {
        int R = mat.length;
        //create a new matrix called rotatedMat with the length of mat matrix to store the rotated matrix.
        int[][] rotatedMat = new int[R][R];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < R; c++) {
                // new row = prev column
                // new column = n - 1 - prev row
                rotatedMat[c][R - 1 - r] = mat[r][c];
            }
        }
        return rotatedMat;
    }
}
