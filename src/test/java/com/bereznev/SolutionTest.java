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

  public static Stream<Arguments> dayOfYearSource() {
    return Stream.of(
        Arguments.of("2019-01-09", 9),
        Arguments.of("2019-02-10", 41),
        Arguments.of("2003-03-01", 60),
        Arguments.of("1992-09-14", 258)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "dayOfYearSource")
  public void dayOfYearTest(String input, int expected) {
    assertEquals(expected, solution.dayOfYear(input));
  }

  public static Stream<Arguments> strStrSource() {
    return Stream.of(
        Arguments.of("sadbutsad", "sad", 0),
        Arguments.of("hello", "ll", 2),
        Arguments.of("abc", "c", 2),
        Arguments.of("mississippi", "issip", 4)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "strStrSource")
  public void strStrTes(String haystack, String needle, int expected) {
    assertEquals(expected, solution.strStr(haystack, needle));
  }

  public static Stream<Arguments> climbStairsSource() {
    return Stream.of(
        Arguments.of(2, 2),
        Arguments.of(3, 3)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "climbStairsSource")
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
        Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}, 2)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "removeDuplicatesSource")
  public void removeDuplicates(int[] input, int[] expectedArr, int expectedLength) {
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

  public static Stream<Arguments> isParenthesesValidSource() {
    return Stream.of(
        Arguments.of("()", true),
        Arguments.of("[]", true),
        Arguments.of("{}", true),
        Arguments.of("()[]{}", true),
        Arguments.of("()[]{", false),
        Arguments.of("[", false),
        Arguments.of("[[", false),
        Arguments.of("]]", false)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "isParenthesesValidSource")
  public void isParenthesesValidTest(String string, boolean expected) {
    assertEquals(expected, solution.isParenthesesValid(string));
  }

  @ParameterizedTest
  @CsvSource({"4, 2", "9, 3", "8, 2"})
  public void mySqrtTest(int x, int expected) {
    assertEquals(expected, solution.mySqrt(x));
  }

  public static Stream<Arguments> isPalindromeSource() {
    return Stream.of(
        Arguments.of(121, true),
        Arguments.of(-121, false),
        Arguments.of(10, false),
        Arguments.of(1221, true)
    );
  }

  @ParameterizedTest
  @MethodSource(value = "isPalindromeSource")
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

  public static Stream<Arguments> romanToIntSource() {
    return Stream.of(
        Arguments.of("", "0"),
        Arguments.of("I", "1"),
        Arguments.of("VI", "6"),
        Arguments.of("IX", "9"),
        Arguments.of("LVIII", "58"),
        Arguments.of("MCMXCIV", "1994")
    );
  }

  @ParameterizedTest
  @MethodSource(value = "romanToIntSource")
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
