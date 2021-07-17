package playcode.dp;

public class RemoveOneElementIncreasing1909 {

    public boolean canBeIncreasing(int[] nums) {

        //approach one: delete every element and try
        //approach dp:
        int size = nums.length;
        int[] dp0 = new int[size];
        Integer[] dp1 = new Integer[size];
        dp0[0] = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i - 1] < nums[i]) {
                dp0[i] = dp0[i - 1] + 1;
            } else {
                dp0[i] = 1;
            }

            if (nums[i - 1] < nums[i]) {
                if (dp1[i - 1] == null) {
                    dp1[i] = dp0[i];
                }

            } else {
                dp1[i] = Math.max(dp0[i - 2] + 1, 0);


            }
        }

            return true;


        }


    }
