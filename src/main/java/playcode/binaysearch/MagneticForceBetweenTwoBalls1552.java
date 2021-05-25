package playcode.binaysearch;

import java.util.*;

public class MagneticForceBetweenTwoBalls1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int size = position.length;
        if (m > size) return 0;

        int left = 1;
        int right = position[size - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isWorked(mid, position, m)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isWorked(int distance, int[] pos, int m) {
        int last = pos[0];
        m--;
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - distance >= last) {
                m--;
                if (m <= 0) return true;
                last = pos[i];
            }
        }
        return false;
    }
}
