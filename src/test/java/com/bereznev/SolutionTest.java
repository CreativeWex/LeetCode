package com.bereznev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Solution.class)
class SolutionTest {
  @Autowired
  Solution solution;

  @ParameterizedTest
  @CsvSource({
      "abcd, abcde, e",
      "ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor, qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj, t"
  })
  public void findTheDifferenceTest(String s, String t, char expected) {
    assertEquals(expected, solution.findTheDifference(s, t));
  }

  @ParameterizedTest
  @CsvSource({
      "abc, pqr, apbqcr",
      "ab, pqrs, apbqrs"
  })
  public void mergeAlternatelyTest(String word1, String word2, String expected) {
    assertEquals(expected, solution.mergeAlternately(word1, word2));
  }

  public static Stream<Arguments> containsNearbyDuplicateSource() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 1}, 3, true),
        Arguments.of(new int[]{1, 0, 1, 1}, 1, true),
        Arguments.of(new int[]{1, 2, 3, 1, 2, 3}, 2, false),
        Arguments.of(new int[]{2, 2}, 3, true)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "containsNearbyDuplicateSource")
  public void containsNearbyDuplicateTest(int[] nums, int k, boolean expected) {
    assertEquals(expected, solution.containsNearbyDuplicate(nums, k));
  }

  @ParameterizedTest
  @CsvSource({
      "2019-01-09, 9",
      "2019-02-10, 41",
      "2003-03-01, 60",
      "1992-09-14, 258",
  })
  public void dayOfYearTest(String input, int expected) {
    assertEquals(expected, Solution.dayOfYear(input));
  }

  @ParameterizedTest
  @CsvSource({
      "sadbutsad, sad, 0",
      "hello, ll, 2",
      "abc, c,2",
      "mississippi, issip, 4",
  })
  public void strStrTes(String haystack, String needle, int expected) {
    assertEquals(expected, solution.strStr(haystack, needle));
  }

  @ParameterizedTest
  @CsvSource({
      "2, 2",
      "3, 3",
  })
  public void climbStairsTest(int input, int expected) {
    assertEquals(expected, solution.climbStairs(input));
  }

  public static Stream<Arguments> sumOfUniqueSource() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 2}, 4),
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),
        Arguments.of(new int[]{1, 1, 1, 1, 1}, 0)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "sumOfUniqueSource")
  public void sumOfUniqueTest(int[] input, int expected) {
    assertEquals(expected, solution.sumOfUnique(input));
  }

  public static Stream<Arguments> removeDuplicatesSource() {
    return Stream.of(
        Arguments.of(new int[]{1, 1, 2}, 2)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "removeDuplicatesSource")
  public void removeDuplicates(int[] input, int expectedLength) {
    assertEquals(expectedLength, solution.removeDuplicates(input));
  }

  public static Stream<Arguments> containsDuplicateSource() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 1}, true),
        Arguments.of(new int[]{1, 2, 3, 4}, false),
        Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "containsDuplicateSource")
  public void containsDuplicate(int[] input, boolean expected) {
    assertEquals(expected, solution.containsDuplicate(input));
  }

  public static Stream<Arguments> majorityElementSource() {
    return Stream.of(
        Arguments.of(new int[]{3, 2, 3}, 3),
        Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "majorityElementSource")
  public void majorityElementTest(int[] input, int expected) {
    assertEquals(expected, solution.majorityElement(input));
  }

  public static Stream<Arguments> maxProfitSource() {
    return Stream.of(
        Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
        Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
        Arguments.of(new int[]{2, 4, 1}, 2),
        Arguments.of(new int[]{3, 2, 6, 5, 0, 3}, 4)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "maxProfitSource")
  public void maxProfitTest(int[] input, int expected) {
    assertEquals(expected, solution.maxProfit(input));
  }

  public static Stream<Arguments> singleNumberSource() {
    return Stream.of(
        Arguments.of(new int[]{2, 2, 1}, 1),
        Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
        Arguments.of(new int[]{1}, 1)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "singleNumberSource")
  public void singleNumberTest(int[] input, int expected) {
    assertEquals(expected, solution.singleNumber(input));
  }

  @ParameterizedTest
  @CsvSource({
      "(), true",
      "[], true",
      "{}, true",
      "()[]{}, true",
      "()[]{, false",
      "{, false",
      "[[, false",
      "]], false",
  })
  public void isParenthesesValidTest(String string, boolean expected) {
    assertEquals(expected, solution.isParenthesesValid(string));
  }

  @ParameterizedTest
  @CsvSource({"4, 2", "9, 3", "8, 2"})
  public void mySqrtTest(int x, int expected) {
    assertEquals(expected, solution.mySqrt(x));
  }

  @ParameterizedTest
  @CsvSource({
      "121, true",
      "-121, false",
      "10, false",
      "1221, true",
  })
  public void isPalindromeTest(int x, boolean expected) {
    assertEquals(expected, solution.isPalindrome(x));
  }

  public static Stream<Arguments> longestCommonPrefixSource() {
    return Stream.of(
        Arguments.of(new String[]{}, ""),
        Arguments.of(new String[]{null}, ""),
        Arguments.of(new String[]{"11", null}, ""),
        Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
        Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
        Arguments.of(new String[]{"a"}, "a"),
        Arguments.of(new String[]{"ab", "a"}, "a"),
        Arguments.of(new String[]{"flower", "flower", "flower", "flower"}, "flower")
    );
  }

  @ParameterizedTest
  @MethodSource(value = "longestCommonPrefixSource")
  public void longestCommonPrefixTest(String[] input, String expected) {
    assertEquals(expected, solution.longestCommonPrefix(input));
  }

  @ParameterizedTest
  @CsvSource({
      "I, 1",
      "VI, 6",
      "IX, 9",
      "LVIII, 58",
      "MCMXCIV, 1994",
  })
  public void romanToIntTest(String input, String result) {
    assertEquals(Integer.parseInt(result), solution.romanToInt(input));
  }

  public static Stream<Arguments> twoSumSource() {
    return Stream.of(
        Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
        Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
        Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2})
    );
  }

  @ParameterizedTest
  @MethodSource(value = "twoSumSource")
  public void twoSumTest(int[] nums, int target, int[] expected) {
    assertArrayEquals(expected, solution.twoSum(nums, target));
  }
}
