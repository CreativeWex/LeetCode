package com.bereznev;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class Solution {

  //  https://leetcode.com/problems/longest-common-prefix/description/?source=submission-ac
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0 || Arrays.stream(strs) .anyMatch(Objects::isNull)) {
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
