

package playcode.prefix;

/*
Hash+Prefix
930.Binary-Subarrays-With-Sum (M)
1371.Find-the-Longest-Substring-Containing-Vowels-in-Even-Counts (H-)
1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR (H-)
1524.Number of Sub-arrays With Odd Sum (M)
1542.Find-Longest-Awesome-Substring (H)
1567.Maximum-Length-of-Subarray-With-Positive-Product (M+)
1590.Make-Sum-Divisible-by-P (H-)
1658.Minimum-Operations-to-Reduce-X-to-Zero (M)
1915.Number-of-Wonderful-Substrings (M)
 */
public class NumberWonderfulSubstrings {
    //1915
    //1542 //1524
    //525/ 930

    //i as the end
    // in [j:i] how many count meet: 1) all even, or 2) one is odd
    // there are two condition:
    //1)if the state of i and the state of j are same, then [j:i] all are even chars
    // why? because odd-odd = even; even-even = even
    //2) they are one bit of state i and state j is different;
    // why: odd -even = odd; even - odd = odd;

    //aba
    public long wonderfulSubstrings(String word) {
        int state = 0;
        long[] counts = new long[1 << 10];
        counts[0] = 1;
        long result = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            state = state ^ (1 << (c - 'a'));
            //1) all even at pos i;
            result += counts[state];
            //2) previous have one bit diff

            for (int pos = 0; pos < 10; pos++) {
                int diff1 = state ^ (1 << (pos));
                result += counts[diff1];
            }
            counts[state]++;
        }
        return result;
    }

}
