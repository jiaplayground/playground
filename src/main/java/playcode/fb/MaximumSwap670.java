package playcode.fb;

public class MaximumSwap670 {

    // split the num to array of digits also work
    public int maximumSwap(int num) {
        String s = "" + num;
        int size = s.length();
        int[] suffixMax = new int[size];
        suffixMax[size - 1] = size - 1;
        for (int i = size - 2; i > 0; i--) {
            if (s.charAt(i) > s.charAt(suffixMax[i + 1])) {
                suffixMax[i] = i;
            }
            else {
                suffixMax[i]=suffixMax[i + 1];
            }
        }
        for (int i = 0; i < size - 1; i++) {
            if (s.charAt(i) < s.charAt(suffixMax[i + 1])) {
                StringBuilder sb = new StringBuilder(s);
                char tmpJ = s.charAt(i);
                sb.setCharAt(i, s.charAt(suffixMax[i + 1]));
                sb.setCharAt(suffixMax[i + 1], tmpJ);
                return Integer.parseInt(sb.toString());
            }
        }
        return num;
    }


}
