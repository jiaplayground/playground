package playcode.aoa;

public class MaximumRemovableCharacters1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canRemove(s, p, removable, mid)) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos + 1;
    }

    private boolean canRemove(String s, String p, int[] removable, int pos) {
        char[] aS = s.toCharArray();
        for (int i = 0; i <= pos; i++) {
            aS[removable[i]] = '$';
        }
        char[] aP = p.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (aS[i] == aP[j]) {
                j++;
            }
            if (j == p.length()) {
                return true;
            }
        }
        return false;
    }
}
