package com.bereznev;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class Solution {

  // https://leetcode.com/problems/find-the-difference/?envType=study-plan-v2&envId=programming-skills
  public char findTheDifference(String s, String t) {
    char r = 0;
    for (char c : s.toCharArray()) {
      r ^= c;
    }
    for (char c : t.toCharArray()) {
      r ^= c;
    }
    return r;
  }

  // https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=programming-skills
  public String mergeAlternately(String word1, String word2) {
    StringBuilder result = new StringBuilder();
    if (word1.length() > word2.length()) {
      for (int i = 0; i < word2.length(); i++) {
        result.append(word1.charAt(i)).append(word2.charAt(i));
      }
      result.append(word1.substring(word2.length()));
    } else {
      for (int i = 0; i < word1.length(); i++) {
        result.append(word1.charAt(i)).append(word2.charAt(i));
      }
      result.append(word2.substring(word1.length()));
    }
    return result.toString();
  }

  // https://leetcode.com/problems/contains-duplicate-ii/description/
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0) {
      return false;
    }

    Map<Integer, Integer> num2Frequency = new HashMap<>(nums.length);
    Map<Integer, Integer> num2Index = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      int seenBeforeAmount = num2Frequency.getOrDefault(nums[i], 0) + 1;
      if (seenBeforeAmount > 1 && Math.abs(i - num2Index.get(nums[i])) <= k) {
        return true;
      }
      num2Frequency.put(nums[i], seenBeforeAmount);
      num2Index.put(nums[i], i);
    }
    return false;
  }

 // https://leetcode.com/problems/day-of-the-year/
 public static int dayOfYear(String date) {
   return LocalDate.parse(date).getDayOfYear();
 }

  // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || haystack.isEmpty() || !haystack.contains(needle)) {
      return -1;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.startsWith(needle, i)) {
        return i;
      }
    }
    return -1;
  }

  // https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length == 2) {
      return true;
    }
    int[] point1 = coordinates[0];
    int[] point2 = coordinates[1];
    for (int i = 2; i < coordinates.length; i++) {
      int[] currentPoint = coordinates[i];
      if ((point2[1] - point1[1]) * (currentPoint[0] - point1[0]) != (currentPoint[1] - point1[1]) * (point2[0] - point1[0])) {
        return false;
      }
    }
    return true;
  }

  // https://leetcode.com/problems/climbing-stairs/description/
  public int climbStairs(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    int prev = 1, curr = 1;
    for (int i = 2; i <= n; i++) {
      int temp = curr;
      curr = prev + curr;
      prev = temp;
    }
    return curr;
  }

  // https://leetcode.com/problems/sum-of-unique-elements/description/
  public int sumOfUnique(int[] nums) {
    return Arrays.stream(nums)
        .filter(i -> Arrays.stream(nums)
            .filter(num -> num == i)
            .count() == 1)
        .sum();
  }

  public String defangIPaddr(String address) {
    return address.replace(".", "[.]");
  }

  // https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1190891598/
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int uniqueCount = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[uniqueCount] = nums[i];
        uniqueCount++;
      }
    }
    return uniqueCount;
  }

  // https://leetcode.com/problems/contains-duplicate/
  public boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> seenBefore = new HashMap<>();
    for (Integer num : nums) {
      int quantity = seenBefore.getOrDefault(num, 0) + 1;
      if (quantity == 2) {
        return true;
      }
      seenBefore.put(num, quantity);
    }
    return false;
  }

  // https://leetcode.com/problems/majority-element-ii/
  public List<Integer> majorityElementTwo(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return Collections.emptyList();
    }
    Set<Integer> majorityElements = new HashSet<>();
    Map<Integer, Integer> quantityNumber = new HashMap<>();
    for (Integer num : nums) {
      int timesSeenBefore = quantityNumber.getOrDefault(num, 0) + 1;
      if (timesSeenBefore > n / 3) {
        majorityElements.add(num);
      }
      quantityNumber.put(num, timesSeenBefore);
    }
    return new ArrayList<>(majorityElements);
  }

  // https://leetcode.com/problems/majority-element/description/
  public int majorityElement(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    Map<Integer, Integer> quantityNumber = new HashMap<>();
    for (Integer num : nums) {
      int timesSeenBefore = quantityNumber.getOrDefault(num, 0) + 1;
      if (timesSeenBefore > n / 2) {
        return num;
      }
      quantityNumber.put(num, timesSeenBefore);
    }
    return 0;
  }

  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
  public int maxProfit(int[] prices) {
    int minPrice = prices[0];
    int maxProfit = 0;
    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      } else {
        if (price - minPrice > maxProfit) {
          maxProfit = price - minPrice;
        }
      }
    }
    return maxProfit;
  }

  //todo unit-test
  // https://leetcode.com/problems/plus-one/
  public int[] plusOne(int[] digits) {
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;
    return newNumber;
  }


  // https://leetcode.com/problems/single-number/
  public int singleNumber(int[] nums) {
    Map<Integer, Integer> seenBefore = new TreeMap<>();

    for (int num : nums) {
      seenBefore.put(num, seenBefore.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : seenBefore.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return 0;
  }

  // https://leetcode.com/problems/length-of-last-word/
  public int lengthOfLastWord(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    if (!s.contains(" ")) {
      return s.length();
    }
    String[] words = s.split(" ");
    return words[words.length - 1].length();
  }

  //todo unit-test
  // https://leetcode.com/problems/search-insert-position/
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  //  https://leetcode.com/problems/valid-parentheses/description/
  public boolean isParenthesesValid(String s) { //NOSONAR
    if (s == null || s.length() % 2 != 0) {
      return false;
    }
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char opening = stack.pop();
        if ((c == ')' && opening != '(') || (c == ']' && opening != '[') || (c == '}' && opening != '{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  //  https://leetcode.com/problems/sqrtx/description/
  public int mySqrt(int x) {
    long r = x;
    while (r * r > x) {
      r = (r + x / r) / 2;
    }
    return (int) r;
  }

  //  https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
  public String firstPalindrome(String[] words) {
    for (String word : words) {
      String firstHalf = word.substring(0, word.length() / 2);
      String secondHalf;
      if (word.length() % 2 != 0) {
        secondHalf = word.substring(word.length() / 2 + 1);
      } else {
        secondHalf = word.substring(word.length() / 2);
      }
      if (firstHalf.equals(new StringBuilder(secondHalf).reverse().toString())) {
        return word;
      }
    }
    return "";
  }

  // https://leetcode.com/problems/palindrome-number/submissions/1174861513/
  public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }

    String input = String.valueOf(x);
    String firstHalf = input.substring(0, input.length() / 2);
    String secondHalf;
    if (input.length() % 2 != 0) {
      secondHalf = input.substring(input.length() / 2 + 1);
    } else {
      secondHalf = input.substring(input.length() / 2);
    }
    return firstHalf.equals(new StringBuilder(secondHalf).reverse().toString());
  }

  //  https://leetcode.com/problems/longest-common-prefix/description/?source=submission-ac
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0 || Arrays.stream(strs).anyMatch(Objects::isNull)) {
      return "";
    }
    int maxLen = Arrays.stream(strs).map(String::length).min(Integer::compareTo).orElse(0);
    if (maxLen == 0) {
      return "";
    }
    for (int i = 0; i < maxLen; i++) {
      if (strs[i].length() == 1) {
        return strs[i];
      }
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].length() == 1) {
          return strs[j];
        }
        if (strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return "";
  }

  // https://leetcode.com/problems/roman-to-integer/
  public int romanToInt(String s) {
    Map<Character, Integer> romanDigits = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    if (s == null || s.isEmpty()) {
      return 0;
    }
    int result = 0;
    int prevValue = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      int currValue = romanDigits.get(s.charAt(i));
      if (currValue < prevValue) {
        result -= currValue;
      } else {
        result += currValue;
      }
      prevValue = currValue;
    }
    return result;
  }

  //  https://leetcode.com/problems/two-sum/
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> value2Index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (Map.Entry<Integer, Integer> entry : value2Index.entrySet()) {
        int value = entry.getKey();
        int index = entry.getValue();
        if (value + nums[i] == target) {
          int[] result = new int[]{i, index};
          Arrays.sort(result);
          return result;
        }
      }
      if (!value2Index.containsKey(nums[i])) {
        value2Index.put(nums[i], i);
      }
    }
    return new int[]{0, 0};
  }
}
