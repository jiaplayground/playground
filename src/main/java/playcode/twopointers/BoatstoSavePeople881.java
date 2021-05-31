package playcode.twopointers;

import java.util.Arrays;

public class BoatstoSavePeople881 {
    //bucket sort can optimize further
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int size = people.length;
        int left = 0;
        int right = size - 1;
        int count = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit && left != right) {
                left++;
                right--;
                count++;
            } else {
                right--;
                count++;
            }
        }
        return count;
    }
}
