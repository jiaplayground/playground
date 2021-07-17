package playcode.dd;

public class CountValidPickupDeliveryOptions1359 {
    /**
     * give n pair;
     * think 1:
     * first we have n choice for pickup, we have 2n-1 place to deliver
     * Then we have n-1 choice for pickup, we have 2(n-1)-1 place to deliver
     *
     *https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/516933/C%2B%2BPython-1-line-Simple-permutation-with-explanation
     * Stage 1
     * We decide the order of all the pickups. It is trivial to tell there are n! possibilities
     * Stage 2
     * Given one possibility. Let's say the pickups are ordered like this A B C
     * We can now insert the corresponding deliveries one by one.
     * We start with the last pickup we made, namely, insert c, and there is only 1 valid slot.
     * A B C c
     * We continue with the second last pickup we made, namely, insert b, and there are 3 valid slots.
     * A B x C x c x (where x denotes the location of valid slots for b)
     * Let's only consider one case A B C c b. We continue with the third last pickup we made, namely, insert a, and there are 5 valid slots.
     * A x B x C x c x b x, (where x denotes the location of valid slots for a)
     * In conclusion. we have in total 1 * 3 * 5 * ... * (2n-1) possibilities
     * Thus, the final solution is n! * (1 * 3 * 5 * ... * (2n-1)) % 1000000007
     */
    private static long MOD = 1_000_000_007;
    public int countOrders1(int n) {
        long result =1;
        for(long i = n; i>=1; i--){
            result = result * i *(2*i -1)%MOD;
        }
        return (int) result;
    }
/**
 * Thing 2:
 * total permutation (2n)!
 * and each of them half is valid
 *   (2n)!/2^n
 *
 *
 */
}
