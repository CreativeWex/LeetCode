package com.bereznev;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Solution {

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

  //todo unit-test
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
